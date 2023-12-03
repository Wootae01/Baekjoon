#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main(void) {
	int n; //전체 후보 수
	int candinated[50] = { 0 }; //각 후보의 득표 수 저장할 변수 
	int count = 0; //몇 명을 매수했는지 저장할 변수
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &candinated[i]);
	}
	while (1) {
		int most_index = 0;

		//가장 많은 득표수를 가진 후보를 찾는다.
		for (int i = 0; i < n; i++) {
			if (candinated[i] >= candinated[most_index]) {
				most_index = i;
			}
		}

		//1번 후보가 가장 많은 득표수를 받으면 반복문 나간다.
		if (most_index == 0) {
			printf("%d", count);
			break;
		}
		//위의 경우가 아니면 사람을 매수한다.
		else {
			candinated[most_index]--;
			candinated[0]++;
			count++;
		}
	}
}
