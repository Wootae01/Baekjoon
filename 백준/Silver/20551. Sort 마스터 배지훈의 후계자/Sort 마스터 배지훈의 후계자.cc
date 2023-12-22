#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<int>A(N);
	vector<int>D(M);

	for (int i = 0; i < N; i++)
	{
		cin >> A[i];
	}

	for (int i = 0; i < M; i++)
	{
		cin >> D[i];
	}

	sort(A.begin(), A.end());


	for (int i = 0; i < M; i++)
	{
		int left = 0;
		int right = N - 1;
		int answer;
		int mid;
		bool check = false;

		while (left <= right)
		{
			mid = (left + right) / 2;

			if (A[mid] < D[i])
			{
				left = mid + 1;
			}
			else
			{
				answer = mid;
				right = mid - 1;
			}

			if (A[mid] == D[i])
			{
				check = true;
			}
		}

		if (check)
		{
			cout << answer << "\n";
		}
		else
		{
			cout << -1 << "\n";
		}
	}
}