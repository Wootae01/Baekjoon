#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int myMin(int x, int y) {
	return (x > y) ? y : x;
}
int main(void) {
	int n;
	scanf("%d", &n);
	int* dp = new int[n + 1];
	
	dp[0] = dp[1] = 0;
	for (int i = 2; i <= n; i++) {
		dp[i] = dp[i - 1] + 1;
		if (i % 3 == 0) {
			dp[i] = myMin(dp[i / 3] + 1, dp[i]);
		}
		if (i % 2 == 0) {
			dp[i] = myMin(dp[i / 2] + 1, dp[i]);
		}
	}

	printf("%d", dp[n]);
	
	delete[] dp;
	return 0;
}