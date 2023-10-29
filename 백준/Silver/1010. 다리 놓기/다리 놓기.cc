#include <iostream>
using namespace std;


//calculate combination 
int combination(int n, int r ){
	int result = 1;
	for (int i = 0; i < r; i++) {
		result *= (n - i);
		result /= (i + 1);
	}

	return result;
}

int main(void)
{
	int repeat;
	int n, m;
	
	cin >> repeat;

	for (int i = 0; i < repeat; i++) {
		cin >> n; cin >> m;
		cout << combination(m, n) << endl;
	}


}