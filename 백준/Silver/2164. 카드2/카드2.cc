#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
using namespace std;

int main(void) {
	int n;
	queue<int> q;
	scanf("%d", &n);
	
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	while (q.size() > 1) {
		q.pop();
		q.push(q.front());
		q.pop();
	}
	printf("%d", q.front());
}