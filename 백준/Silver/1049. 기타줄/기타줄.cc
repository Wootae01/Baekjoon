#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n, m;
	int res = 0;
	scanf("%d %d", &n, &m);

	int piece, package;
	int min_piece, min_package;

	scanf("%d%d", &min_package, &min_piece);
	for (int i = 0; i < m-1; i++) {
		scanf("%d %d", &package, &piece);
		if (min_piece > piece) {
			min_piece = piece;
		}
		if (min_package > package) {
			min_package = package;
		}
	}
	
	if (min_piece * 6 < min_package) {
		res = min_piece * n;
	}
	else {
		while (1) {
			if (n >= 6) {
				res += min_package;
				n -= 6;
			}
			else {
				if (min_piece * n < min_package) {
					res += min_piece * n;
					break;
				}
				else {
					res += min_package;
					break;
				}
			}
		}
	}
	printf("%d", res);
		
}