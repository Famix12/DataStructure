
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TestGraph {

    public static void main(String[] args) {
        GraphAsLists graph = initGraph("GraphDataC.txt"); //GraphDataA.txt
        int option, id;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("\n***************************");
            System.out.println("*   Testing Graph  *");
            System.out.println("***************************\n");
            System.out.println("1.  Print Graph");
            System.out.println("2.  Print Graph Traversals");
            System.out.println("3.  Print Predecessors and Successors of a vertex");
            System.out.println("4.  Print Incident and Emanating Edges of a vertex");
            System.out.println("5.  Quit");

            System.out.print("\nSelect an Option [1...5] : ");
            option = reader.nextInt();

            switch (option) {
                case 1:
                    System.out.println(graph);
                    break;

                case 2:
                    System.out.println("Depth First Traversal:");
                    graph.depthFirstTraversal(0);
                    System.out.println();
                    System.out.println("Breadth First Traversal:");
                    graph.breadthFirstTraversal(0);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Enter the ID of a vertex to print its Successors and Predecessors: ");
                    id = reader.nextInt();
                    System.out.print("Successors of Vertex " + id + " are:   " + graph.getVertex(id).getSuccessors());

                    System.out.print("\nPredecessors of Vertex " + id + " are: " + graph.getVertex(id).getPredecessors());
                    break;

                case 4:
                    System.out.print("Enter the ID of a vertex to print its Incident and Emanating edges: ");
                    id = reader.nextInt();
                    System.out.print("Incident edges for Vertex " + id + " are:  " + graph.getIncidentEdges(id));

                    System.out.print("\nEmanating edges for Vertex " + id + " are: " + graph.getEmanatingEdges(id));
                    break;

            } //end of switch

        } while (option != 5);
    }

    //assumes first line contains size followed by D for directed graph or U for undirected graph 
    //followed by possible comments.
    //remaining lines contains two digits each, representing the the edges.
    public static GraphAsLists initGraph(String dataFile) {
        try {
            Scanner reader = new Scanner(new File(dataFile));

            GraphAsLists graph;
            int v0, v1, size;
            double weight;
            String line;
            String[] tokens;

            line = reader.nextLine();
            tokens = line.split("\\s+");
            size = Integer.parseInt(tokens[0]);
            if (tokens[1].equals("D")) {
                graph = new GraphAsLists(size, true);
            } else {
                graph = new GraphAsLists(size, false);
            }

            //add verices
            if (tokens.length == size + 2) //if there are vertex labes
            {
                for (int i = 0; i < size; i++) {
                    graph.addVertex(tokens[i + 2]);
                }
            } else // no labes
            {
                for (int i = 0; i < size; i++) {
                    graph.addVertex();
                }
            }

            //add edges   
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                tokens = line.split("\\s+");

                v0 = Integer.parseInt(tokens[0]);
                v1 = Integer.parseInt(tokens[1]);
                if (tokens.length > 2) {
                    weight = Double.parseDouble(tokens[2]);
                    graph.addEdge(v0, v1, weight);
                } else {
                    graph.addEdge(v0, v1);
                }
            }
            reader.close();
            return graph;
        } catch (IOException ex) {
            System.out.println("File Error");
            return null;
        }
    }
}
