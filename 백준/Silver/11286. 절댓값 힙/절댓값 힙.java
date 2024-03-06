import java.io.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Heap heap = new Heap(n);
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                bw.write(heap.pop() + "\n");
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

    Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }
    void push(int x){
        heap[size++] = x;

        int current = size - 1;
        int parent = (current - 1) / 2;

        while(Math.abs(heap[current]) <= Math.abs(heap[parent])){

            if(Math.abs(heap[current]) == Math.abs(heap[parent])){
                if(heap[current] >= heap[parent]){
                    break;
                }
            }

            //swap
            int tmp = heap[current];
            heap[current] = heap[parent];
            heap[parent] = tmp;

            current = parent;
            parent = (current - 1) / 2;
        }

    }
    int pop(){
        if (size == 0) {
            return 0;
        }

        int min = heap[0];
        int parent = 0;
        heap[0] = heap[--size];
        while(true){
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;
            int minChild = parent;

            if(leftChild < size && Math.abs(heap[leftChild]) <= Math.abs(heap[minChild])){
                if(Math.abs(heap[leftChild]) == Math.abs(heap[minChild])){
                    if(heap[leftChild] < heap[minChild]){
                        minChild = leftChild;
                    }
                } else{
                    minChild = leftChild;
                }
            }
            if (rightChild < size && Math.abs(heap[rightChild]) <= Math.abs(heap[minChild])) {
                if(Math.abs(heap[rightChild]) == Math.abs(heap[minChild])){
                    if(heap[rightChild] < heap[minChild]){
                        minChild = rightChild;
                    }
                } else{
                    minChild = rightChild;
                }
            }

            if(minChild == parent){
                break;
            }

            int tmp = heap[minChild];
            heap[minChild] = heap[parent];
            heap[parent] = tmp;
            parent = minChild;
        }

        return min;
    }
}
