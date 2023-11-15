#include <iostream>
#include <cstring>
using namespace std;

int sum_digit(char* str) {
	int sum = 0;
	for (int i = 0; i < strlen(str); i++) {
		sum += str[i] - '0';
	}
	return sum;
}

void intToString(char* str, int num) {
	int count = 0;
	char tmp[1000001];
	while (num > 0) {
		tmp[count++] = num % 10 + '0';
		num /= 10;
		
	}
	tmp[count] = '\0';

	int i;
	for (i = 0; i < count; i++) {
		str[i] = tmp[count - i -1];
	}
	str[i] = '\0';
	
}

void is_multipl3(char str[], int count) {
	int sum;
	if (strlen(str) <= 1) {
		sum = sum_digit(str);
		cout << count << endl;
		if (sum % 3 == 0) {
			cout << "YES" << endl;
		}
		else {
			cout << "NO" << endl;
		}
	}
	else {
		sum = sum_digit(str);
		count++;
		intToString(str, sum);
		is_multipl3(str, count);
	}
}
int main(void) {
	char str[1000001];
	cin >> str;
	is_multipl3(str, 0);
	return 0;
}