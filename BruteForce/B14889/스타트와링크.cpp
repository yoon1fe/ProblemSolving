#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N;
int m[21][21] = { 0, };
bool people[21] = { 0, };
vector<int> start;
vector<int> link;
vector<pair<int, int>> sStat;
vector<pair<int, int>> lStat;
int first;
int second;
int sSum = 0;
int lSum = 0;
int minMinus = 99999;

void solve() {
	for (int i = 0; i < sStat.size(); i++)
		sSum += m[sStat.at(i).first][sStat.at(i).second];
	for (int i = 0; i < lStat.size(); i++)
		lSum += m[lStat.at(i).first][lStat.at(i).second];
	
	sStat.clear();
	lStat.clear();
	minMinus = min(minMinus, abs(sSum - lSum));
	sSum = 0;
	lSum = 0;
}

void makeStartStat(int cnt) {
	if (cnt == 2) {
		sStat.push_back({ first, second });
		return;
	}
	for (int i = 0; i < start.size(); i++) {
		if (start.at(i) == first) continue;
		second = start.at(i);
		makeStartStat(cnt+1);
	}
}

void makeLinkStat(int cnt) {
	if (cnt == 2) {
		lStat.push_back({ first, second });
		return;
	}
	for (int i = 0; i < link.size(); i++) {
		if (link.at(i) == first) continue;
		second = link.at(i);
		makeLinkStat(cnt + 1);
	}
}


void makeTeam() {
	for (int i = 1; i <= N; i++) {
		if (people[i])
			start.push_back(i);
		else link.push_back(i);
	}


	for (int i = 0; i < start.size(); i++) {	//다시 순열로 좌표 만들기
		first = start.at(i);
		makeStartStat(1);
	}

	for (int i = 0; i < link.size(); i++) {
		first = link.at(i);
		makeLinkStat(1);
	}

	solve();	//각 좌표에 있는 값 더하기

	start.clear();
	link.clear();
}

void makePeople(int range, int cnt) {	//N/2만큼 순열 만들기
	if (cnt == N/2) {
		makeTeam();	//만들어지면 팀 나누기
		return;
	}

	for (int i = range + 1; i <= N; i++) {
		people[i] = true;
		makePeople(i, cnt + 1);
		people[i] = false;
	}
}

int main() {
	cin >> N;

	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= N; j++)
			cin >> m[i][j];

	for (int i = 1; i <= N; i++) {
		people[i] = true;
		makePeople(i, 1);
		people[i] = false;
	}

	cout << minMinus;

	return 0;
}