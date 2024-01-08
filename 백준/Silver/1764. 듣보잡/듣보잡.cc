#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int binary_search(string* arr, string str, int start, int end) {
	if (start > end) {
		return -1;
	}
	int mid = (start + end) / 2;

	if (arr[mid] == str) {
		return mid;
	}
	else if (arr[mid] > str) {
		return binary_search(arr, str, start, mid -1);
	}
	else if (arr[mid] < str) {
		return binary_search(arr, str, mid + 1, end);
	}
	
}
string res[500000];

int main(void) {

	int n, m;
	int count = 0;
	int k = 0;
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	string* arr1 = new string[n];
	string* arr2 = new string[m];
	for (int i = 0; i < n; i++) {
		cin >> arr1[i];
	}
	for (int i = 0; i < m; i++) {
		cin >> arr2[i];
	}

	sort(arr1, arr1 + n);
	sort(arr2, arr2 + m);

	for (int i = 0; i < n; i++) {
		string tmp = arr1[i];
		
		if (binary_search(arr2, tmp, 0, m - 1) == -1)
			continue;
		
		count++;
		res[k++] = tmp;
	}
	cout << count << "\n";
	for (int i = 0; i < k; i++) {
		cout << res[i] << "\n";
	}
    return 0;
}