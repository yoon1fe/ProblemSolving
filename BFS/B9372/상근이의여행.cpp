#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int T, N, M;		//�׽�Ʈ ���̽� ��, ���� ��, ����� ��

int main() {
	int a, b;
	cin >> T;
	
	while (T != 0) {
		cin >> N >> M;

		for (int i = 0; i < M; i++)
			cin >> a >> b;

		cout << N - 1 << endl;
		T--;
	}
	
	return 0;
}