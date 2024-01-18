package Homework1;

public class StackTest {
    
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        System.out.println("Is stack empty? - " + stack.empty());
        // Add elements to the stack
        stack.push(1); // Add it to the stack
        stack.toString();
        stack.push(2); // Add it to the beginning of the stack
        stack.toString();
        System.out.println("Is stack empty now? - " + stack.empty());
        stack.push(3); // Add it to the end of the stack
        stack.toString();
        stack.push(4); // Add it to the end of the stack
        stack.toString();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(5); // Add it to the stack at index 2
        stack.toString();
        stack.push(6); // Add it to the stack at index 5
        stack.toString();
        System.out.println("The first element of the stack is - " + stack.peek());
        System.out.println("The size of the stack is - " + stack.getSize());
        stack.push(7);
        stack.toString();
    }

}
