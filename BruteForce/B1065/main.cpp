#include <iostream>
#include <algorithm>
#include <math.h>
using namespace std;


int main() {
	int N, first, second, third;
	cin >> N;
	int count = 0;
	if (N < 100)
		cout << N << endl;
	else if (99 < N && N <= 110)
		cout << 99 << endl;
	else if (N == 1000)
		cout << 144 << endl;
	else {
		for (int i = N; i > 110; i--) {
			first = i / 100;
			second = (i - (first * 100)) / 10;
			third = i - (first * 100) - (second * 10);
			if (first - second == second - third) {
				count++;
			}
		}
		cout << count + 99 << endl;
	}
	
	return 0;
}