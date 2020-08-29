#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int gear[5][8] = { 0, };
int K;
int gearNum, dir;
int ans = 0;

void rotateGear(int n, int dir) {
	if (dir == 1) {		//시계 방향
		int temp = gear[n][7];
		for (int i = 7; i > 0; i--) {
			gear[n][i] = gear[n][i - 1];
		}
		gear[n][0] = temp;
	}
	else if (dir == -1) {	//반시계 방향
		int temp = gear[n][0];
		for (int i = 0; i < 7; i++) {
			gear[n][i] = gear[n][i + 1];
		}
		gear[n][7] = temp;
	}
}

void move(int n, int dir) {
	vector<bool> isDiff;
	for (int i = 1; i < 4; i++) {
		if (gear[i][2] == gear[i + 1][6])
			isDiff.push_back(false);
		else isDiff.push_back(true);
	}
	
	rotateGear(n, dir);

	switch (n) {
	case 1:
		if (isDiff.at(0)) {
			rotateGear(2, -1 * dir);
			if (isDiff.at(1)) {
				rotateGear(3, dir);
				if (isDiff.at(2)) {
					rotateGear(4, -1 * dir);
				}
			}
		}
		break;

	case 2:
		if (isDiff.at(1)) {
			rotateGear(3, -1 * dir);
			if (isDiff.at(2))
				rotateGear(4, dir);
		}
		if (isDiff.at(0)) {
			rotateGear(1, -1 * dir);
		}
		break;

	case 3:
		if (isDiff.at(1)) {
			rotateGear(2, -1 * dir);
			if (isDiff.at(0))
				rotateGear(1, dir);
		}
		if (isDiff.at(2)) {
			rotateGear(4, -1 * dir);
		}
		break;

	case 4:
		if (isDiff.at(2)) {
			rotateGear(3, -1 * dir);
			if (isDiff.at(1)) {
				rotateGear(2, dir);
				if (isDiff.at(0)) {
					rotateGear(1, -1 * dir);
				}
			}
		}
		break;
	}
}

int main() {
	for (int i = 1; i <= 4; i++)
		for (int j = 0; j < 8; j++)
			scanf("%1d", &gear[i][j]);

	cin >> K;

	for (int i = 0; i < K; i++) {
		cin >> gearNum >> dir;
		move(gearNum, dir);
	}
	int t = 1;
	for (int i = 1; i < 5; i++) {
		if (gear[i][0])
			ans += gear[i][0] * t;

		t *= 2;
	}

	cout << ans;



	return 0;
}