#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> v[201];

    vector<bool> check(n, false);

    for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (computers[i][j]) {
                    v[i].push_back(j);
                    v[j].push_back(i);
				}
			}
    }

    queue<int> q;
    for (int i = 0; i < n; i++) {
        if (!check[i]) {
            answer++;

            q.push(i);
            check[i] = true;
            while (!q.empty()) {
                int cur = q.front();
                q.pop();

                for (int j = 0; j < v[cur].size(); j++) {
                    int next = v[cur][j];
                    if (!check[next]) {
                        check[next] = true;
                        q.push(next);
                    }

                }
            }
        }
    }
    
    return answer;
}

int main() {
    vector<vector<int>> num;
    num.push_back({ 1,1 ,0 });
    num.push_back({ 1,1 ,0 });
    num.push_back({ 0, 0,0 });

    cout << solution(3, num);



    return 0;
}