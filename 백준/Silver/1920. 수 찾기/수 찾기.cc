#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>	
using namespace std;

int binary_search(int* arr, int start, int end, int value) {
	int mid = (start + end) / 2;
	if (start > end) {
		return 0;
	}
	if (arr[mid] < value) {
		return binary_search(arr, mid + 1, end, value);
	}
	else if (arr[mid] == value) {
		return 1;
	}
	else {
		return binary_search(arr, start, mid - 1, value);
	}
}
int main(void) {
	int n;
	scanf("%d", &n);
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + n);
	
	int m, value;
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d", &value);
		printf("%d\n", binary_search(arr, 0, n - 1, value));
	}
	delete[] arr;
	return 0;
}