#include <iostream>
#include <algorithm>

using namespace std;

int N;
int ans;
int nn[7] = { 0, };


int constructor() {
	for (int i = 1; i < N; i++) {
		int j = 0;
		int ans = i;
		int cons = 0;
		cons += i;
		while (i % 10 != 0) {

			nn[j++] = i % 10;
			i /= 10;
		}
		for (int k = 0; k < 7; k++)
			cons += nn[k];

		if (cons == N)
			return ans;
	}
	return 0;
}

int main() {
	cin >> N;
	
	

	cout << constructor() << endl;

	return 0;
}