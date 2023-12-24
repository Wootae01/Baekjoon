#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>

using namespace std;
int main(void) {
	int l, n;
	int res = 0;
	scanf("%d", &l);
	int* arr = new int[l];
	for (int i = 0; i < l; i++) {
		scanf("%d", &arr[i]);
	}
	sort(arr, arr + l);

	scanf("%d", &n);

	int i = 0;
	while (arr[i] < n) {
		i++;
	}
	//[1, n], [2, n] .....[n-1, n]
	//

	if (arr[i] == n) {
		res = 0;
	}
	else {
		int start, end;
		if (i == 0) {
			start = 1;
			end = arr[i] - 1;
		}
		else {
			end = arr[i] - 1;
			start = arr[i - 1] + 1;
		}

		res += n - start; //[start, n], [start+1, n],...,[n-1, n] 
		res += end - n; // [n, end], [n, end-1], ..., [n, n+1]
		
		//n이 start와 n값이 같지 않고, end와 n값이 같지 않으면
		if (start < n && n < end) {
			//범위의 끝값(B)을 고정한다고 하면, 시작 값(A)의 개수는 (n - start)개이다.
			//그런데 될 수 있는 B값이 (end - n)개이므로 다음과 같다.
			res += (n - start) * (end - n);
		}
		
	}
	printf("%d", res);
	delete[] arr;
}