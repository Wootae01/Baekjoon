#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>	
#include <queue>
using namespace std;

bool compare(int x, int y) {
	return x > y;
}
int main(void) {
	int repeat, n, m;
	scanf("%d", &repeat);
	int* resArr = new int[repeat];
	for (int i = 0; i < repeat; i++) {
		scanf("%d %d", &n, &m);
		queue<int> q;
		int* priority = new int[n];
			
		for (int i = 0; i < n; i++) {
			scanf("%d", &priority[i]);
			q.push(priority[i]);
		}
		int priority_m = priority[m];
		sort(priority, priority + n, compare);

		int idx = 0;
		int res = 1;

		while (!q.empty()) {
			if (priority[idx] == priority_m && m == 0) {
				resArr[i] = res;
				break;
			}

			else if (q.front() == priority[idx]) {
				q.pop();
				m--;
				res++; idx++;
			}
			else {
				if (m == 0) {
					m += q.size() - 1;
				}
				else {
					m--;
				}
				q.push(q.front());
				q.pop();
			}
		}
		delete[] priority;
	}

	for (int i = 0; i < repeat; i++) {
		printf("%d\n", resArr[i]);
	}
	return 0;
}