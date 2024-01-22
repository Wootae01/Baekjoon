#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main(void) {
	int n, res = 0;
	vector<vector<int>> graph;
	vector<bool> isVisited;
	queue<int> q;
	scanf("%d", &n);

	graph.assign(n + 1, vector<int>(0, 0));
	isVisited.assign(n + 1, false);

	int pair;
	scanf("%d", &pair);
	for (int i = 0; i < pair; i++) {
		int x, y;
		scanf("%d %d", &x, &y);
		graph[x].push_back(y);
		graph[y].push_back(x);
	}

	int node = 1;
	q.push(node);
	isVisited[1] = true;

	while (!q.empty()) {
		node = q.front();
		q.pop();
		
		for (int i = 0; i < graph[node].size(); i++) {
			int tmp = graph[node][i];
			if (!isVisited[tmp]) {
				q.push(tmp);
				isVisited[tmp] = true;
				res++;
			}
		}
	}
	
	printf("%d", res);
	return 0;
}