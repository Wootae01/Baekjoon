#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, m;
	scanf("%d %d", &n, &m);
	bool* isPrime = new bool[m + 1];
	for (int i = 0; i < m + 1; i++) {
		isPrime[i] = false;
	}
	isPrime[0] = isPrime[1] = true;
	for (int i = 2; i * i <= m; i++) {
		int j = 2;
		while (i * j <= m) {
			if (isPrime[i * j] == false) {
				isPrime[i * j] = true;
			}
			j++;
		}
	}
	for (int i = n; i <= m; i++) {
		if (!isPrime[i]) {
			printf("%d\n", i);
		}
	}
	delete[] isPrime;
	return 0;
}