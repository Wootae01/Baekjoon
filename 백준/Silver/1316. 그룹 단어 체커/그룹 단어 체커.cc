#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
using namespace std;


int main(void) {
	int n, res = 0;
	bool check[26];
	scanf("%d", &n);
	getchar();
	for(int i = 0; i < n; i++) {
		string str;
		cin >> str;
		
		for (int j = 0; j < 26; j++) {
			check[j] = false;
		}

		char pre = str[0];
		bool flag = false;
		for (int j = 0; j < str.length(); j++) {
			int tmp = str[j] - 'a';
			if (check[tmp] == true && pre != str[j]) {
				flag = true;
				break;
			}
			check[tmp] = true;
			pre = str[j];
		}
		if (!flag)
			res++;
	}
	printf("%d", res);
}