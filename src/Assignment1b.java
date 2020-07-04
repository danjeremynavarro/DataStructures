import java.lang.reflect.Array;

class EmptyError extends Exception{
    EmptyError(){
        super("Empty Instance");
    }
}

class Stack<T>{
    private Queue queue1;
    private Queue queue2;

    Stack(Class<T> type, int size){
        queue1 = new Queue(type, size);
        queue2 = new Queue(type, size);
    }

    public void push (T data){

    }

}

class Queue<T>{
    private Class<T> dataType;
    private T[] container;
    private int size = 0;
    private int head;
    private int tail;

    Queue(Class<T> type, int size){
        dataType = type;
        container = newArray(size);
    }

    public boolean isEmpty(){
        if (this.size == 0){
            return true;
        } else {
            return false;
        }
    }

    public void push(T data){
        if (this.size == 0){
            this.head = 0;
            this.tail = 0;
        }
        this.container[this.tail] = data;
        this.size++;
        this.tail++;
    }

    public T pop() throws EmptyError{
        if(this.isEmpty()){
            throw new EmptyError();
        }
        T payload = this.container[this.head];
        this.size--;
        this.head++;
        return payload;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size){
        return (T[]) Array.newInstance(dataType, size);
    }
}

class Assignment1b {
    public static void main(String[] args){
        Stack test = new Stack(Integer.class, 10);

    }
}
