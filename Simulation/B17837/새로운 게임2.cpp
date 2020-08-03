#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef struct piece {
	int num;
	int y;
	int x;
	int dir;
}piece;

vector<piece> pieces;
vector<piece> map[12][12];
int mapColor[12][12] = { 0, };
int N, K;
int dy[5] = { 0, 0, 0, -1, 1 };
int dx[5] = { 0, 1, -1, 0, 0 };

bool isIn(int y, int x) {
	if (0 <= y && y < N && 0 <= x && x < N)return true;
	else return false;
}

int move() {
	int turn = 0;
	while (1) {
		turn++;
		if (turn > 1000) {
			return -1;
		}

		for (int i = 0; i < pieces.size(); i++) {
			int cy = pieces[i].y;
			int cx = pieces[i].x;
			int cnum = pieces[i].num;

			int ny = cy + dy[pieces[i].dir];
			int nx = cx + dx[pieces[i].dir];
			vector<piece> temp;
			if (mapColor[ny][nx] == 2 || !isIn(ny, nx)) {	//ÆÄ¶û
				if (pieces[i].dir == 1) {
					pieces[i].dir = 2;
					for (int j = 0; j < map[cy][cx].size(); j++) {
						if (map[cy][cx][j].num == cnum) {
							map[cy][cx][j].dir = 2;
						}
					}
				}
				else if (pieces[i].dir == 2){
					pieces[i].dir = 1; 
					for (int j = 0; j < map[cy][cx].size(); j++) {
						if (map[cy][cx][j].num == cnum) {
							map[cy][cx][j].dir = 1;
						}
					}
				}
				else if (pieces[i].dir == 3){ 
					pieces[i].dir = 4;
					for (int j = 0; j < map[cy][cx].size(); j++) {
						if (map[cy][cx][j].num == cnum) {
							map[cy][cx][j].dir = 4;
						}
					}
				}
				else if (pieces[i].dir == 4){ 
					pieces[i].dir = 3;
					for (int j = 0; j < map[cy][cx].size(); j++) {
						if (map[cy][cx][j].num == cnum) {
							map[cy][cx][j].dir = 3;
						}
					}
				}
			}

			ny = cy + dy[pieces[i].dir];
			nx = cx + dx[pieces[i].dir];

			if (mapColor[ny][nx] == 2 || !isIn(ny, nx)) {	//ÆÄ¶û
				continue;
			}

			for (int j = 0; j < map[cy][cx].size(); j++) {
				if (map[cy][cx][j].num == cnum) {
					for (int k = j; k < map[cy][cx].size(); k++)
						temp.push_back({ map[cy][cx][k].num, ny, nx, map[cy][cx][k].dir });

					map[cy][cx].erase(map[cy][cx].begin() + j, map[cy][cx].end());
					break;
				}
			}

			if(mapColor[ny][nx] == 1)
				reverse(temp.begin(), temp.end());

			for (int j = 0; j < temp.size(); j++) {
				map[ny][nx].push_back(temp[j]);
				pieces[temp[j].num - 1] = temp[j];
			}

			
			
			if (map[ny][nx].size() >= 4)
				return turn;
		}


	}
}

int main() {
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> mapColor[i][j];
		}
	}

	for (int i = 0; i < K; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		map[a - 1][b - 1].push_back({ i + 1, a-1, b-1, c });
		pieces.push_back({ i + 1, a - 1, b - 1, c });
	}

	cout << move();


	return 0;
}