
import java.util.*;

public class GraphAsLists {

    private int numberOfVertices;
    private int numberOfEdges;
    private Vertex vertex[];
    private LinkedList<Edge>[] adjacencyList;
    private boolean isDirected;

    public GraphAsLists(int size, boolean directed) {
        isDirected = directed;
        vertex = new Vertex[size];
        adjacencyList = new LinkedList[size];
        for (int v = 0; v < size; v++) {
            adjacencyList[v] = new LinkedList<Edge>();
        }
    }

    public GraphAsLists(int size) {
        this(size, false);
    }

    //Begining of Vertex class as inner class
    protected class Vertex {

        protected int ID;
        protected Object weight;

        public Vertex(int v, Object wt) {
            ID = v;
            weight = wt;
        }

        public Vertex(int v) {
            this(v, null);
        }

        public int getID() {
            return ID;
        }

        public Object getWeight() {
            return weight;
        }

        public boolean equals(Object obj) {
            Vertex other = (Vertex) obj;
            return ID == other.ID;
        }

        public ArrayList<Edge> getIncidentEdges() {
            return GraphAsLists.this.getIncidentEdges(ID);
        }

        public ArrayList<Edge> getEmanatingEdges() {
            return GraphAsLists.this.getEmanatingEdges(ID);
        }

        public ArrayList<Vertex> getPredecessors() {
            ArrayList<Edge> incidents = getIncidentEdges();
            ArrayList<Vertex> preds = new ArrayList<Vertex>();
            for (Edge edge : incidents) {
                preds.add(edge.getMate(this));
            }
            return preds;
        }

        public ArrayList<Vertex> getSuccessors() {
            ArrayList<Edge> emanatings = getEmanatingEdges();
            ArrayList<Vertex> succs = new ArrayList<Vertex>();
            for (Edge edge : emanatings) {
                succs.add(edge.getMate(this));
            }
            return succs;
        }

        @Override
        public String toString() {
            String s = "V{" + ID;
            if (weight != null) {
                s += ", " + weight;
            }
            s += "}";
            return s;
        }
    } //End of Vertex class

    //Begining of Edge class as an inner class
    protected class Edge implements Comparable<Edge> {

        protected int v0;
        protected int v1;
        protected double weight;

        public Edge(int v, int w, double wt) {
            v0 = v;
            v1 = w;
            weight = wt;
        }

        public Edge(int v, int w) {
            this(v, w, 0.0);
        }

        public Vertex getV0() {
            return vertex[v0];
        }

        public Vertex getV1() {
            return vertex[v1];
        }

        public double getWeight() {
            return weight;
        }

        public Vertex getMate(Vertex v) {
            if (v.getID() == v0) {
                return vertex[v1];
            }
            if (v.getID() == v1) {
                return vertex[v0];
            } else {
                return null;  //invalid argument;  better to throw exception here
            }
        }

        public boolean isDirected() { //edge is directed if its graph is directed
            return GraphAsLists.this.isDirected();
        }

        @Override
        public int compareTo(Edge other) {
            if (weight < other.weight) {
                return -1;
            } else if (weight > other.weight) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Edge other = (Edge) obj;
            return v0 == other.v0 && v1 == other.v1 && weight == other.weight;
        }

        @Override
        public String toString() {
            String s = "E{" + v0;
            if (isDirected()) {
                s += "->" + v1;
            } else {
                s += "--" + v1;
            }
            if (weight != 0.0) {
                s += ", " + weight;
            }
            s += "}";
            return s;
        }
    } //end of the Edge class

    //Begining of Graph methods
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void visit(Vertex v) {
        System.out.print(v + "  ");
    }

    public void addEdge(int v0, int v1, double wt) {
        adjacencyList[v0].add(new Edge(v0, v1, wt));
        numberOfEdges++;
    }

    public void addEdge(int v0, int v1) {
        addEdge(v0, v1, 0.0);
    }

    public Edge getEdge(int v0, int v1) {
        if (v0 < 0 || v0 > numberOfVertices - 1 || v1 < 0 || v1 > numberOfVertices - 1) {
            return null;  //invalid edge;  
        }
        int index = adjacencyList[v0].indexOf(new Edge(v0, v1));
        if (index != -1) {
            return adjacencyList[v0].get(index);
        } else {
            return null;
        }
    }

    public void addVertex(Object wt) { //Note: ID of vertex is auto generated: 0, 1, 2, ...	
        vertex[numberOfVertices] = new Vertex(numberOfVertices, wt);
        numberOfVertices++;
    }

    public void addVertex() {
        addVertex(null);
    }

    public Vertex getVertex(int v) {
        if (v < 0 || v > numberOfVertices - 1) {
            return null;
        } else {
            return vertex[v];
        }
    }

    public Vertex[] getVertices() {
        return vertex;
    }

    public ArrayList<Edge> getEmanatingEdges(int v0) {
        ArrayList<Edge> emanatings = new ArrayList<Edge>();
        emanatings.addAll(adjacencyList[v0]);
        return emanatings;
    }

    public ArrayList<Edge> getIncidentEdges(int v1) {
        ArrayList<Edge> incidents = new ArrayList<Edge>();
        for (int v0 = 0; v0 < numberOfVertices; v0++) {
            int index = adjacencyList[v0].indexOf(new Edge(v0, v1));
            if (index != -1) {
                incidents.add(adjacencyList[v0].get(index));
            }
        }
        return incidents;
    }

    public void depthFirstTraversal(int start) {
        boolean visited[] = new boolean[numberOfVertices];
        for (int v = 0; v < numberOfVertices; v++) {
            visited[v] = false;
        }

        depthFirstTraversal(start, visited);
    }

    private void depthFirstTraversal(int start, boolean[] visited) {

        if (visited[start]) {
            return;
        }

        visit(vertex[start]);
        visited[start] = true;

        ArrayList<Vertex> succs = vertex[start].getSuccessors();
        for (Vertex succ : succs) {
            int id = succ.getID();
            if (!visited[id]) {
                depthFirstTraversal(id, visited);
            }
        }
    }

    public void breadthFirstTraversal(int start) {
        boolean enqueued[] = new boolean[numberOfVertices];
        for (int v = 0; v < numberOfVertices; v++) {
            enqueued[v] = false;
        }

        LLQueue<Vertex> queue = new LLQueue<Vertex>();
        enqueued[start] = true;
        queue.enqueue(vertex[start]);

        while (!queue.isEmpty()) {
            Vertex v = queue.dequeue();
            visit(v);

            ArrayList<Vertex> succs = v.getSuccessors();
            for (Vertex succ : succs) {
                int id = succ.getID();
                if (!enqueued[id]) {
                    queue.enqueue(succ);
                    enqueued[id] = true;
                }
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < numberOfVertices; i++) {
            s += vertex[i] + ":";
            s += "\t" + adjacencyList[i] + "\n";
        }
        return s;
    }
}
