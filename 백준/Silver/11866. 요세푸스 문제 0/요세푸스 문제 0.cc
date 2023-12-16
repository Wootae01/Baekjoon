#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	int n, k;
	queue<int> q;

	scanf("%d %d", &n, &k);
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}

	printf("<");
	while (q.size() != 0) {
		for (int i = 0; i < k - 1; i++) {
			q.push(q.front());
			q.pop();
		}
		if (q.size() != 1) {
			printf("%d, ", q.front());
			q.pop();
		}
		else if (q.size() == 1) {
			printf("%d>", q.front());
			q.pop();
		}
	}
}