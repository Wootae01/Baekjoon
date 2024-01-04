#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);
	int res = 0;
	int count = 0;
	while (1) {
		int tmp = res;
		int six = 0;
		while (tmp > 0) {
			if (tmp % 10 == 6) {
				six++;

				if (six >= 3) {
					count++;
					break;
				}
			}
			else {
				six = 0;
			}
			tmp /= 10;
		}

		if (count == n) {
			printf("%d\n", res);
			break;
		}

		res++;
	}
	return 0;
}