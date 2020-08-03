#include <iostream>
#include <algorithm>

using namespace std;

int N, S;
int ns[20];
int ans = 0;

void sumOfSubset(int index, int sum) {
	if (index >= N)
		return; 

	sum += ns[index];

	if (sum == S)
		ans++;

	sumOfSubset(index + 1, sum - ns[index]);
	sumOfSubset(index + 1, sum);

}

int main() {
	cin >> N >> S;
	
	for (int i = 0; i < N; i++)
		cin >> ns[i];

	sumOfSubset(0, 0);

	cout << ans << endl;



	return 0;
}