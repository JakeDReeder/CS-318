public class StackOfIntegers {
    
    private int[] elements;
    private int size;

    // contructing empty stack of default size of 16.
    public StackOfIntegers() {
        size = 16;
        elements = new int[size];
    }

    // contructing empty stack of a specified capacity.
    public StackOfIntegers(int capacity) {
        size = capacity;
        elements = new int[size];
    }

    // returns truen if stack is empty
    public boolean empty() {
        if (size == 0) {return true;}
        else {return false;}
    }


}
