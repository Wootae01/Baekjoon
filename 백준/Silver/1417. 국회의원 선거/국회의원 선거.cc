#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n;
	int candinated[50] = { 0 };
	int count = 0;
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &candinated[i]);
	}
	while (1) {
		int most_index = 0;
		for (int i = 0; i < n; i++) {
			if (candinated[i] >= candinated[most_index]) {
				most_index = i;
			}
		}

		if (most_index == 0) {
			printf("%d", count);
			break;
		}
		else {
			candinated[most_index]--;
			candinated[0]++;
			count++;
		}
	}
}