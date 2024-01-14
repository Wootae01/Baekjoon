#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);

	int* arr = new int[n];
	int res = -1;
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	
	sort(arr, arr + n);
	for (int i = n - 1; i >= 2; i--) {
		if (arr[i] < arr[i - 1] + arr[i - 2]) {
			res = arr[i] + arr[i - 1] + arr[i - 2];
			break;
		}
	}

	printf("%d", res);
	return 0;
}