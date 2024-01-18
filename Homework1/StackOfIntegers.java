package Homework1;

public class StackOfIntegers {
    
    private int[] elements;
    private int size;

    // contructing empty stack of default size of 16.
    public StackOfIntegers() {
        elements = new int[16];
    }

    // contructing empty stack of a specified capacity.
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    // returns truen if stack is empty
    public boolean empty() {
        if (size == 0) {return true;}
        else {return false;}
    }

    // returns integer at the top of the stack without removing it.
    public int peek() {
        int top = elements[size-1];
        return top;
    }

    //stores an integer into the top of the stack.
    public void push(int value) {
        if (size >= elements.length) {
            int[] newElements = new int[elements.length + 1];
            for (int i = 0; i < elements.length-1; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        size++;
        elements[size-1] = value;
    }

    //Removes the integer at the top of the stack.
    public int pop(){
        int top = elements[size-1];
        size = size - 1;
        return top;
    }

    // returns number of elements in a stack.
    public int getSize() {
        return size;
    }

}

