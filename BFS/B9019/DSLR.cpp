#include <iostream>
#include <algorithm>
#include <queue>
#include <cstring>
using namespace std;

int T, A, B;
string c[10000];

int L(int num) {
	int a, b;
	if (num < 1000) {
		return num * 10;
	}
	else {
		a = num % 1000;
		b = num / 1000;
		a *= 10;

		return a + b;
	}
}

int R(int num) {
	int a, b;
	a = num % 10;
	b = (num - a) / 10;
	a *= 1000;

	return a + b;
}

string bfs(int s, int B) {
	queue<int> q;
	q.push(s);
	c[s] = "1";
	int next;
	string n;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		if (cur == B)
			return c[cur].substr(1, c[cur].size());
		
		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:						//D
				next = (cur * 2) % 10000;
				n = "D";
				break;
			
			case 1:						//S
				next = cur - 1;
				if (next < 0)
					next = 9999;
				n = "S";
				break;

			case 2:						//L
				next = L(cur);
				n = "L";
				break;

			case 3:						//R
				next = R(cur);
				n = "R";
				break;
			}

			if (c[next].empty()) {
				q.push(next);
				c[next] = c[cur] + n;
			}
		}
	}
}

int main() {
	cin >> T;

	for (int i = 0; i < T; i++) {
		cin >> A >> B;
		cout << bfs(A, B) << endl;

		for (int j = 0; j < 10000; j++)
			c[j].clear();
	}

	return 0;
}