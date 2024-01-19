#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
	int n, t;
	scanf("%d", &t);
	int arr0[41];
	int arr1[41];
	arr0[0] = 1; arr0[1] = 0; arr0[2] = 1;
	arr1[0] = 0; arr1[1] = 1; arr1[2] = 1;

	for (int i = 0; i < t; i++) {
		scanf("%d", &n);
		for (int i = 3; i <= n; i++) {
			arr0[i] = arr0[i - 1] + arr0[i - 2];
			arr1[i] = arr1[i - 1] + arr1[i - 2];
		}
		printf("%d %d\n", arr0[n], arr1[n]);
	}
	
	return 0;
	
}
