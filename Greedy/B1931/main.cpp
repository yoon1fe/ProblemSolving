#include <iostream>
#include <algorithm>
using namespace std;

typedef struct mtime {
	int start;
	int end;
}mtime;

bool cmp(mtime p1, mtime p2) { 
	if (p1.end == p2.end)
		return p1.start < p2.start;
	else
		return p1.end < p2.end; 
}

int main() {
	int n, cnt = 1;
	mtime *conf;
	mtime temp;
	cin >> n;
	conf = new mtime[n];

	for (int i = 0; i < n; i++)
		cin >> conf[i].start >> conf[i].end;

	sort(conf, conf+n, cmp);
	temp.start = conf[0].start;
	temp.end = conf[0].end;

	for (int i = 1; i < n; i++) {
		if (conf[i].start >= temp.end) {
			cnt++;
			temp.start = conf[i].start;
			temp.end = conf[i].end;
		}
	}

	cout << cnt << endl;

	delete conf;
	return 0;
}