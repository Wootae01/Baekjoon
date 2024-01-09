#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;
	
	map<string, string> mp;

	string address, password;
	for (int i = 0; i < n; i++) {
		cin >> address >> password;
		mp.insert({ address, password });
	}

	for (int i = 0; i < m; i++) {
		cin >> address;
		if (mp.find(address) != mp.end()) {
			cout << mp[address] << "\n";
		}
	}
	return 0;
}