#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);
	
	long long dp[91];
	dp[0] = 0; dp[1] = 1; dp[2] = 1;

	for (int i = 3; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 2];
	}
	printf("%lld", dp[n]);

	return 0;
}