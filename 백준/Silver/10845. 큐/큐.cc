#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>

class BaseArray {
	int* mem;
	int capacity;
public:
	BaseArray(int capacity) {
		this->capacity = capacity;
		mem = new int[capacity];
	}
	~BaseArray() {
		delete[] mem;
	}

	int get(int index) { return mem[index]; }
	void put(int index, int value) { mem[index] = value; }
	int getCapacity() { return capacity; }
};

class MyQueue : BaseArray {
	int size;
public:
	MyQueue(int cap) : BaseArray(cap) {
		size = 0;
	}
	int empty() { return (size == 0) ? 1 : 0; }
	void push(int val) { put(size++, val); }
	int pop() {
		if (empty()) return -1;
		int tmp = get(0);
		size--;
		for (int i = 0; i < size; i++) {
			put(i, get(i + 1));
		}
		return tmp;
	}

	int getSize() { return size; }
	void front() {
		if (empty() == 1) {
			printf("-1\n");
		}
		else {
			printf("%d\n", get(0));
		}
	}
	void back() {
		if (empty() == 1) {
			printf("-1\n");
		}
		else {
			printf("%d\n", get(size - 1));
		}
	}

};
int main(void) {
	char cmd[10];
	int n, x;
	MyQueue q(10000);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", cmd);

		if (strcmp(cmd, "push") == 0) {
			scanf("%d", &x);
			q.push(x);
		}
		else if (strcmp(cmd, "pop") == 0) {
			printf("%d\n", q.pop());
		}
		else if (strcmp(cmd, "size") == 0) {
			printf("%d\n", q.getSize());
		}
		else if (strcmp(cmd, "empty") == 0){
			printf("%d\n", q.empty());
		}
		else if (strcmp(cmd, "front") == 0) {
			q.front();
		}
		else if (strcmp(cmd, "back") == 0) {
			q.back();
		}
	}
}