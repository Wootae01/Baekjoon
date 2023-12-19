#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

void merge(int* arr, int left, int mid, int right) {
	int* sorted = new int[right - left + 1];
	
	int i = left;
	int j = mid + 1;
	int k = 0;

	while (i <= mid && j <= right) {
		if (arr[i] <= arr[j])
			sorted[k++] = arr[i++];
		else
			sorted[k++] = arr[j++];
	}
	if (i > mid) {
		while (j <= right) {
			sorted[k++] = arr[j++];
		}
	}
	else {
		while (i <= mid) {
			sorted[k++] = arr[i++];
		}
	}

	for (i = left, k = 0; i <= right; i++, k++) {
		arr[i] = sorted[k];
	}
	delete[] sorted;
}
void mergeSort(int* arr, int left, int right) {
	if (left >= right)
		return;
	
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, mid, right);

}
void printArray(int* arr, int size) {
	for (int i = 0; i < size; i++) {
		printf("%d\n", arr[i]);
	}
}
int main(void) {
	int n;
	scanf("%d", &n);
	
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	mergeSort(arr, 0, n - 1);
	printArray(arr, n);
	delete[] arr;
	return 0;
}