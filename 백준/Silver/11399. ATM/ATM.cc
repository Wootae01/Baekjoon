#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);
	
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + n);
	int sum = 0;
	int res = 0;
	for (int i = 0; i < n; i++) {
		sum += arr[i];
		res += sum;
	}
	printf("%d", res);
	return 0;
}
