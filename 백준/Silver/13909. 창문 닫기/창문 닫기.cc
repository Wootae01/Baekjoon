#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n;
	scanf("%d", &n);
	int res = 0;
	int count = 0;
	for (int i = 1; i <= n; i++) {
		if (i * i <= n) {
			res++;
		}
		else {
			break;
		}
	}
	printf("%d", res);
}