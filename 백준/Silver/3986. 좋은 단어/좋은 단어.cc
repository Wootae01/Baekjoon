#include <iostream>
#include <string>
using namespace std;

int main(void) {
	string str;
	int res = 0;
	int n;
	char stack[100000] = "\0";
	cin >> n;
	cin.ignore();
	for (int i = 0; i < n; i++) {
		getline(cin, str);
		int size = 0;

		for (int j = 0; j < str.size(); j++) {
			if (size == 0) {
				stack[size++] = str[j];
			}
			else {
				if (stack[size - 1] == str[j]) {
					stack[size - 1] = '\0';
					size--;
				}
				else {
					stack[size++] = str[j];
				}
			}
			
		}
		if (size == 0) {
			res++;
		}

		
	}

	cout << res << endl;
	return 0;
}