#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

void mySwap(int& a, int& b) {
	int tmp = a;
	a = b;
	b = tmp;
}

int main(void) {
	int n;
	scanf("%d", &n);

	int* a = new int[n];
	int* b = new int[n];

	for (int i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &b[i]);
	}

	bool* check = new bool[n];
	
	for (int i = 0; i < n; i++) {
		check[i] = false;
	}

	for (int i = 0; i < n; i++) {
		int maxIdx = -1;
		int minIdx = -1;
		for (int j = 0; j < n; j++) {
			if (maxIdx == -1 && check[j] == false) {
				maxIdx = j;
			}
			else if (b[j] >= b[maxIdx] && check[j] == false) {
				maxIdx = j;
			}
		}

		for (int j = 0; j < n; j++) {
			if (minIdx == -1 && check[j] == false) {
				minIdx = j;
			}
			if (a[j] <= a[minIdx] && check[j] == false) {
				minIdx = j;
			}
		}

		mySwap(a[maxIdx], a[minIdx]);
		check[maxIdx] = true;
	}

	int res = 0;
	for (int i = 0; i < n; i++) {
		res += a[i] * b[i];
	}
	printf("%d", res);
	delete[] a; delete[] b;
}