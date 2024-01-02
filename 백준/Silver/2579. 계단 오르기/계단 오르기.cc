#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int myMax(int x, int y) {
	return (x > y) ? x : y;
}

int main(void) {
	int count = 0, res, n;
	
	scanf("%d", &n);
	
	int* arr = new int[n];
	int* dp = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}

	dp[0] = arr[0];
	dp[1] = arr[0] + arr[1];
	dp[2] = myMax(arr[0] + arr[2], arr[1] + arr[2]);
	for (int i = 3; i < n; i++) {
		dp[i] = myMax(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
	}
	printf("%d", dp[n - 1]);
	
	delete[] arr; delete[] dp;
	return 0;
}