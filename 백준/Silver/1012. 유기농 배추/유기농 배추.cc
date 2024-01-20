#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>

using namespace std;


bool check[51][51];
int dx[] = { -1, 1, 0 , 0 };
int dy[] = { 0, 0, 1, -1 };
int arr[51][51];
int n, m, k;

void dfs(int x, int y) {
	check[x][y] = true;
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if (0 <= nx && nx < n && 0 <= ny && ny < m) {
			if (arr[nx][ny] == 1 && check[nx][ny] == false) {
				dfs(nx, ny);
			}
		}
		else continue;
	}
}
int main(void) {
	int t;
	
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d %d %d", &n, &m, &k);

		memset(arr, 0, sizeof(arr));
		memset(check, false, sizeof(check));

		for (int j = 0; j < k; j++) {
			int x, y;
			scanf("%d %d", &x, &y);
			arr[x][y] = 1;
		}

		int res = 0;
		for (int j = 0; j < n; j++) {
			for (int l = 0; l < m; l++) {
				if (arr[j][l] == 1 && !check[j][l]) {
					res++;
					dfs(j, l);
				}
			}
		}
		printf("%d\n", res);
	}
}