#include <iostream>
#include <cstring>
using namespace std;

//각 자리수의 합을 계산하는 함수
int sum_digit(char* str) {
	int sum = 0;
	for (int i = 0; i < strlen(str); i++) {
		sum += str[i] - '0';
	}
	return sum;
}

//원래 숫자를 각 자리의 숫자의 합으로 바꾸는 함수.
void changeNum(char* str, int num) {
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

//3의 배수인지 확인하는 함수
void is_multipl3(char str[], int count) {
	int sum;

	//한자리 숫자이면
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

	//한자리 숫자 이상이면
	else {
		sum = sum_digit(str);
		count++;
		changeNum(str, sum);
		is_multipl3(str, count);
	}
}
int main(void) {
	char str[1000001];
	cin >> str;
	is_multipl3(str, 0);
	return 0;
}
