#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int N1, N2, t;
string g1, g2, ant;
bool LR[26] = { 0, };		//true: 오른쪽, false: 왼쪽

void solve() {
	for (int i = 0; i < t; i++) {
		for (int j = 0; j < g1.size() + g2.size() - 1; j++) {
			if (LR[j] == false && LR[j] != LR[j + 1]) {
				swap(ant[j], ant[j + 1]);
				swap(LR[j], LR[j + 1]);
				j++;
			}
		}
	}
}

int main() {
	cin >> N1 >> N2;
	cin >> g1 >> g2;

	reverse(g1.begin(), g1.end());
	for (int i = 0; i < g2.size(); i++) {
		LR[g1.size() + i] = true;
	}
	ant = g1 + g2;

	cin >> t;

	solve();
	cout << ant;

	return 0;
}