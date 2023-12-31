#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

int main(void) {
	int m, n;
	int guess = -1, guess_row, guess_col;
	char x, y;
	scanf("%d %d", &n, &m);
	getchar();
	char** arr = new char* [n];
	
	for (int i = 0; i < n; i++) {
		arr[i] = new char[m];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%c", &arr[i][j]);
		}
		getchar();
	}
	
	
	int flag = 0;
	for (int k = 0; k < 2; k++) {
		int start_row = 0, start_col = 0;
		while (start_row + 8 <= n) {
			int tmp = 0;
			char ch;
			ch = (flag == 0) ? 'B' : 'W';
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (i % 2 == 0) {
						if (j % 2 == 0 && arr[start_row + i][start_col + j] != ch) {
							tmp++;
						}
						else if (j % 2 == 1 && arr[start_row + i][start_col + j] == ch) {
							tmp++;
						}
					}
					else {
						if (j % 2 == 0 && arr[start_row + i][start_col + j] == ch) {
							tmp++;
						}
						else if (j % 2 == 1 && arr[start_row + i][start_col + j] != ch) {
							tmp++;
						}
					}
				}
			}
			if (tmp < guess || guess < 0) {
				guess = tmp;
			}
			start_col++;
			if (start_col + 8 > m) {
				start_col = 0;
				start_row++;
			}
		}
		flag = 1;
	}
	printf("%d", guess);
	for (int i = 0; i < n; i++) {
		delete[] arr[i];
	}

	delete[] arr;
    return 0;
}