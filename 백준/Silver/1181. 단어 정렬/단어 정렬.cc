#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
using namespace std;

bool compare(string a, string b) {
	if (a.length() == b.length()) {
		return a < b;
	}
	else {
		return a.length() < b.length();
	}
}
int main(void) {
	int n;
	scanf("%d", &n);
	string* arr = new string[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + n, compare);
	for (int i = 0; i < n; i++) {
		if (arr[i] == arr[i + 1])
			continue;
		cout << arr[i] << "\n";
	}
}