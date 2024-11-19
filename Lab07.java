class Queue{
    int front, size, capacity;
    int array[];

    public Queue(int length){
        capacity = length;
        front = size = 0;
        array = new int[capacity];
    }
    boolean isFull(){
        return (size == capacity);
    }
    boolean isEmpty(){
        return (size == 0);
    }
    // method to add an itom to the queue
    //it changes rear and size
    void enqueue(int item){
       if(isFull()){
           return;
       }
       int pos ;
       pos = (front+size)%capacity;
       array[pos] = item;
       size = size+1;
        System.out.println(item + " enqueue to Queue");
       }
       // method to remove item feom queue
    // it changes front and size
    int dequeue(){
        if(isEmpty()){
            return 0;
        }
        int item = array[front];
        front = front + 1;
        size = size-1;
        return item;
    }
      // method to get front of queue
    int front(){
        if(isEmpty()){
            return 0;
        }
        return array[front];
    }
    }

public class Lab07 {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println("size of queue : "+queue.size);
        queue.enqueue(77);

        System.out.println(queue.dequeue()+ " dequeued from queue \n");
        System.out.println("Front item is "+ queue.front());
    }
}
