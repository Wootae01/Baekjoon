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

class MyStack : BaseArray {
	int size;
public:
	MyStack(int cap) : BaseArray(cap) { size = 0; }

	int empty() { return (size == 0) ? 1 : 0; }
	void push(int val) { put(size++, val); }
	int pop() {
		return (empty() == 1) ? -1 : get(--size);
	}
	int getSize() { return size; }
	void top() {
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
	MyStack st(10000);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", cmd);

		if (strcmp(cmd, "push") == 0) {
			scanf("%d", &x);
			st.push(x);
		}
		else if (strcmp(cmd, "pop") == 0) {
			printf("%d\n", st.pop());
		}
		else if (strcmp(cmd, "size") == 0) {
			printf("%d\n", st.getSize());
		}
		else if (strcmp(cmd, "empty") == 0){
			printf("%d\n", st.empty());
		}
		else if (strcmp(cmd, "top") == 0) {
			st.top();
		}
	}
}