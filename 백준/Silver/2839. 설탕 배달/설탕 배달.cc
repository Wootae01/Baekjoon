#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;
//백준 2839

int main(void) {
	int n;
	scanf("%d", &n);
	
	int res = -1;
	int tmp = 0;
	for (int i = 0; 3*i <= n; i++) {
		for (int j = 0; 5 * j <= n; j++) {
			if (5 * j + 3 * i == n) {
				tmp = i + j;
				if (res == -1 || tmp < res) {
					res = tmp;
				}
			}
		}
	}
	printf("%d", res);
	return 0;
}