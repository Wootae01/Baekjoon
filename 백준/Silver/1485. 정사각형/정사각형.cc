#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;

class Point {
public:
	int x, y;
	Point(int x, int y) {
		this->x = x;
		this->y = y;
	}
	Point() { x = y = 0; }
};

double distance(Point p1, Point p2) {
	return sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
}

bool compare(Point p1, Point p2) {
	if (p1.x == p2.x) {
		return p1.y < p2.y;
	}
	else {
		return p1.x < p2.x;
	}
}
int main(void) {
	int t;
	int x, y;
	scanf("%d", &t);

	Point arr[4];
	for (int i = 0; i < t; i++) {
		for(int j = 0; j < 4; j++)
			scanf("%d %d", &arr[j].x, &arr[j].y);

		sort(arr, arr + 4, compare);
		double d1 = distance(arr[0], arr[1]);
		double d2 = distance(arr[0], arr[2]);
		
		if (d1 == d2) {
			double d3 = distance(arr[0], arr[3]);
			double d4 = distance(arr[1], arr[2]);
			if (d3 == d4) {
				printf("1\n");
			}
			else {
				printf("0\n");
			}
		}
		else {
			printf("0\n");
		}
	}

	return 0;
}