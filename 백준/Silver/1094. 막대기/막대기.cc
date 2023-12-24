#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int tmp[7];
	for (int i = 0; i < 7; i++) {
		tmp[i] = 0;
	}
	int x, size = 0;
	int stick = 64;
	int res = -1;
	scanf("%d", &x);
	

	while (size < 7) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += tmp[i];
		}
		sum += stick;

		if (sum < x) {
			tmp[size++] = stick;
		}
		else if (sum == x) {
			res = size + 1;
			break;
		}
		stick /= 2;
	}
	printf("%d", res);
}