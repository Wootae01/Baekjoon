import org.w3c.dom.Node;

import java.io.*;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        Heap heap = new Heap(n);
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                bw.write(heap.pop()+"\n");
            } else{
                heap.push(x);
            }
        }
        bw.flush(); bw.close();
    }
}
class Heap{
    private int[] heap;
    private int capacity;
    private int size;

    public Heap(int capacity){
        this.capacity = capacity;
        size = 0;
        heap = new int[capacity];
    }

    void push(int x){
        heap[size++] = x;
        int current = size - 1;
        int parent = (current - 1) / 2;
        while(heap[parent] > heap[current]){
            int tmp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = tmp;

            current = parent;
            parent = (current - 1) / 2;
        }
    }

    int pop(){
        if (size == 0) {
            return 0;
        }
        int result = heap[0];
        heap[0] = heap[--size];

        int parent = 0;
        while (true) {
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;
            int maxChildIndex = parent;

            if (leftChild < size && heap[leftChild] < heap[maxChildIndex]) {
                maxChildIndex = leftChild;
            }
            if (rightChild < size && heap[rightChild] < heap[maxChildIndex]) {
                maxChildIndex = rightChild;
            }

            if (maxChildIndex == parent) {
                break;
            }

            int tmp = heap[parent];
            heap[parent] = heap[maxChildIndex];
            heap[maxChildIndex] = tmp;

            parent = maxChildIndex;
        }
        return result;

    }

}
