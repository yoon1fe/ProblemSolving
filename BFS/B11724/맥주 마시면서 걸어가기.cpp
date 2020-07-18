#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int t, n;
int check[102] = { 0, };
vector<int> graph[102];

int distance(pair<int, int> f, pair<int, int> s) {
	return abs(f.first - s.first) + abs(f.second - s.second);
}

void dfs(int node)

{

    check[node] = true;



    for (int i = 0; i < graph[node].size(); i++)

    {

        int next = graph[node][i];

        if (check[next] == false)

            dfs(next);

    }

}
int main() {
	cin >> t;


	for (int i = 0; i < t; i++) {
        for (int j = 0; j < 102; j++)
            graph[j].clear();

        memset(check, false, sizeof(check));
		cin >> n;

        vector<pair<int, int>> coord;


        for (int j = 0; j < n + 2; j++) {
            int y, x;

            cin >> y >> x;

            coord.push_back(make_pair(y, x));
        }

        for (int j = 0; j < n + 2; j++)
            for (int k = j + 1; k < n + 2; k++)
                if (distance(coord[j], coord[k]) <= 50 * 20) {
                    //양방향 그래프

                    graph[j].push_back(k);
                    graph[k].push_back(j);
                }

        dfs(0);


        if (check[n + 1])
            cout << "happy\n";

        else
            cout << "sad\n";
	}


	return 0;
}