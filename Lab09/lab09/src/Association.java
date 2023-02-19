public class Association<K extends Comparable<K>,V> 
            implements Comparable<Association<K,V>>
{
    protected K key; // the key of the key-value pair
    protected V value; // the value of the key-value pair

    public Association(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    public Association(K key)
    {
        this(key,null);
    }

    public K getKey()
    {
        return key;
    }

    public V getValue()
    {
        return value;
    }
    
    public void setValue(V value){
    	this.value = value;
    }

    public boolean equals(Object obj)
    {
        Association other = (Association)obj;
        return getKey().equals(other.getKey());
    }
    

    public int compareTo(Association<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    public String toString()
    {
        String s = "{ " + key;
        if(value != null)
            s = s + " ,   " + value;
        return s + " }";
    }
}
