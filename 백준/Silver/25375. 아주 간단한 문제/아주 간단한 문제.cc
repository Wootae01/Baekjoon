#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
using namespace std;

int main(void) {
	int repeat;
	long long a, b;
	string status = "0\n";
	string result = "";
	scanf("%d", &repeat);

	for (int i = 0; i < repeat; i++) {
		scanf("%lld %lld", &a, &b);
		if (a*2 <= b && b % a == 0) {
			status = "1\n";
		}
		result += status;
		status = "0\n";
	}
	cout << result;
	return 0;
}