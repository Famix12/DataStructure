
public class Item {

    public String name;
    public double price;

    public Item(String n) {
        this(n, 0.0);
    }

    public Item(String n, double p) {
        name = n;
        price = p;
    }

    public boolean equals(Object o) {
        Item other = (Item) o;
        return name.equals(other.name);
    }

    public String toString() {
        return name + "\t" + price;
    }
}
