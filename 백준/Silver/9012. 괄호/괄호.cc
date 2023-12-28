#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <stack>
using namespace std;

int main(void) {
	int n;
	string str;
	stack<char> st;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		cin >> str;
		bool flag = false;
		while (!st.empty()) {
			st.pop();
		}

		for (int j = 0; j < str.length(); j++) {
			if (str[j] == '(') {
				st.push('(');
			}
			else if (str[j] == ')') {
				if (st.empty()) {
					flag = true;
					break;
				}
				st.pop();
			}
		}
		if (st.empty() && !flag) {
			printf("YES\n");
		}
		else {
			printf("NO\n");
		}
	}
    return 0;
}