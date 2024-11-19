import java.util.*;
public class Stack {
    private int[] array;
    private int size;
    private int index = 0;

    public Stack(int size){
        this.size = size;
        array = new int[size];
    }
    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full");
        }
        array[index] = element;
        index++;
    }

    private boolean isFull() {
        if(index == size){
            return true;
        }
        return false;
    }
    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
        }
        return array[--index];
    }

    boolean isEmpty() {
        if(index == 0){
            return true;
        }
        return false;
    }
    public int size(){
        return index;
    }
}
 class StackClient{
     public static void main(String[] args) {
         Stack stack = new Stack(5);
         stack.push(8);
         stack.push(11);
         stack.push(13);
         stack.push(20);
         stack.push(11);

         System.out.println("1. Size of stack after push operations: "+stack.size());

         System.out.println("2. Pop elements from stack: ");
         while(!stack.isEmpty()){
             System.out.print(stack.pop()+" ");
         }
         System.out.println(" \n 3. Size of stack after pop operation: " + stack.size());

     }
}
