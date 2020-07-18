#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
using namespace std;

int N, K;
int maxVal = 0;
bool alphabet[26] = { 0, };
//string isInStr;
map<char, int> isIn;
string t = "";
vector<string> words;

void teach(int idx, int cnt) {
	if (cnt <= K - 5) {
		int maxCnt = 0;
		for (int i = 0; i < words.size(); i++) {
			int c = 0;
			for (int j = 0; j < words[i].size(); j++) {
				if (alphabet[words[i][j] - 'a'])
					c++;
			}
			if (c == words[i].size())
				maxCnt++;
		}
		maxVal = max(maxVal, maxCnt);
		
	}

	for (int i = idx; i < t.size(); i++) {
		if (!alphabet[t[i] - 'a']) {
			alphabet[t[i] - 'a'] = true;
			teach(i + 1, cnt + 1);
			alphabet[t[i] - 'a'] = false;
		}
	}
}

int main() {
	cin >> N >> K;
	string actin = "actin";
	string tt = "";
	for (int i = 0; i < actin.size(); i++)
		alphabet[actin[i] - 'a'] = true;

	for (int i = 0; i < N; i++) {
		string temp;
		cin >> temp;
		words.push_back(temp.substr(4, temp.size() - 8));
		t += words[i];
	}
	if (K < 5) {
		cout << 0;
		return 0;
	}
	for (int i = 0; i < t.size(); i++) {
		if (t[i] == 'a' || t[i] == 'c' || t[i] == 't' || t[i] == 'i' || t[i] == 'n') continue;
		isIn.insert(make_pair(t[i], 0));
	}

	t.clear();
	for (auto it = isIn.begin(); it != isIn.end(); it++)
		t += it->first;

	teach(0, 0);

	cout << maxVal;

	return 0;
}