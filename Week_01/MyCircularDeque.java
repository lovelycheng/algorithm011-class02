package Week_01;

/**
 * @author chengtong
 * @date 2020/7/24 07:00
 *
 * 注意单个元素时的特殊处理
 */
public class MyCircularDeque {

    private final int capacity;
    private int size = 0;
    private Node head;
    private Node tail;

    private class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){
            this.value = value;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size == capacity){
            return false;
        }
        if(head == null ){
            head = tail =  new Node(value);
        }else {
            Node node = new Node(value);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size ++;
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == capacity){
            return false;
        }
        if(head == null ){
            head = tail =  new Node(value);
        }else {
            Node node = new Node(value);
            tail.next = node;
            node.prev = tail;

            tail = node;
        }
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size == 0 || head == null){
            return false;
        }
        size--;
        if(head == tail){
            tail = null;
        }
        if(head.next != null){
            head.next.prev = null;
        }
        head = head.next;

        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size == 0 || tail == null){
            return false;
        }
        size--;

        if(tail.prev != null){
            tail.prev.next = null;
        }else {
            head = null; // jdk 这里这么搞的
        }

        tail = tail.prev;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(size == 0 ||  head == null){
            return -1;
        }
        return head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size == 0 || tail == null){
            return -1;
        }
        return tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }


    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(4);

        deque.insertFront(9);
        deque.deleteLast();
        deque.getRear();
        deque.getFront();
        deque.getFront();
        deque.deleteFront();
        deque.insertFront(6);
        deque.insertLast(5);
        deque.insertFront(9);


    }
}
