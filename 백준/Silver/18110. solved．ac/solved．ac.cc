#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);

	int intercept = (int)(n * 0.15 + 0.5);
	int* arr = new int[n];
	for (int i = 0; i < n; i ++ ) {
		scanf("%d", &arr[i]);
	}

	sort(arr, arr + n);

	int sum = 0, res = 0;
	for (int i = intercept; i < n - intercept; i++) {
		sum += arr[i];
	}
	if (n == 0) {
		printf("%d", res);
	}
	else {
		double size = n - intercept * 2;
		res = (int)(sum / size + 0.5);
		printf("%d", res);
		delete[] arr;
	}
	return 0;
}