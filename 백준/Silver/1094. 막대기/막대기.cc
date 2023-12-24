#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int x;
	scanf("%d", &x);
	int res = 0;
	int stick = 64;
	while (stick >= 1) {
		if (stick <= x) {
			res++;
			x -= stick;
		}
		stick /= 2;
	}
	printf("%d", res);
}