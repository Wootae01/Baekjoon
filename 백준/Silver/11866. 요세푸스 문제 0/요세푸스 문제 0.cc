#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, k;
	scanf("%d %d", &n, &k);

	int res[1000];
	int flag[1000] = { 0, };
	int cir = 0;
	int count = 0;
	while (1) {
		for (int i = 0; i < k; i++) {
			if (cir >= n) {
				cir -= n;
			}
			if (flag[cir] == 0) {
				cir++;
			}
			else {
				cir++;
				i--;
			}
			
		}

		res[count++] = cir;
		flag[cir - 1] = 1;
		if (count >= n)
			break;
	}


	printf("<");
	for (int i = 0; i < n - 1; i++) {
		printf("%d, ", res[i]);
	}
	printf("%d>", res[n - 1]);
}