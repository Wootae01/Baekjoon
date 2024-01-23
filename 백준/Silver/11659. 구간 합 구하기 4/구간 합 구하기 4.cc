#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, m;
	
	scanf("%d %d", &n, &m);
	
	int* arr = new int[n + 1];
	int* sum = new int[n + 1];
	
	for (int i = 1; i <= n; i++) {
		scanf("%d", &arr[i]);
		sum[i] = 0;
	}
	arr[0] = 0; sum[0] = 0;
	for (int i = 1; i <= n; i++) {
		sum[i] = sum[i - 1] +  arr[i];
	}

	for (int i = 0; i < m; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		printf("%d\n", sum[y] - sum[x - 1]);

	}
	return 0;
}