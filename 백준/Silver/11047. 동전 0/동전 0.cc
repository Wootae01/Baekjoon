#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, k;
	int res = 0;
	scanf("%d %d", &n, &k);
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	int i = n - 1;
	while (k > 0 && i >= 0) {
		if (k >= arr[i]) {
			res++;
			k -= arr[i];
		}
		else {
			i--;
		}
	}
	printf("%d", res);
	delete[] arr;
	return 0;

}