#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int m, n;
	scanf("%d %d", &m, &n);

	for (int i = m; i <= n; i++) {
		bool flag = false;

		if (i == 1) {
			flag = true;
		}
		for (int j = 2; j * j <= i; j++) {
			if (i % j == 0) {
				flag = true; break;
			}
		}
		if (!flag) {
			printf("%d\n", i);
		}
	}
}