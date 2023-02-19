
public class TestNonTail {
    public static void main(String[] args) {
        nonTail(4);
        System.out.println();
    }
    
    public static void nonTail (int i){
       if (i>0) {
            nonTail(i-1);
            System.out.print (i +" ");
           nonTail(i-1);
        }
    }   
}

