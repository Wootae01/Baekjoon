#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, taesu, p;
	int score;
	int res = -1, rank = 0;
	int list[50];
	for (int i = 0; i < 50; i++) {
		list[i] = -1;
	}

	scanf("%d %d %d", &n, &taesu, &p);
	for (int i = 0; i < n; i++) {
		scanf("%d", &list[i]);
	}

	if (n == 0) {
		res = 1;
	}
	else if (list[p-1] >= taesu) {
		res = -1;
	}
	else {
		for (int i = 0; i < p; i++) {
			if (list[i] > taesu) {	
				rank++;
			}

			else {
				res = rank + 1;
				break;
			}
		}
	}
	printf("%d", res);
}