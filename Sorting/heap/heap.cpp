#include <iostream>
#include <algorithm>

using namespace std;

int heap[9] = { 7,6,5,8,3,5,9,1,6 };


int main(void) {
	for (int i = 1; i < 9; i++) {
		int c = i;
		do {
			int root = (c - 1) / 2;
			if (heap[root] < heap[c]) {
				swap(heap[root], heap[c]);
			}
			c = root;
		} while (c != 0);
	}

	for (int i = 8; i >= 0; i--) {
		swap(heap[0], heap[i]);
		int root = 0;
		int c = 1;

		do {
			c = 2 * root + 1;
			if (heap[c] < heap[c + 1] && c < i - 1)
				c++;
			if (heap[root] < heap[c] && c < i)
				swap(heap[root], heap[c]);
			root = c;
		} while (c < i);
	}
	for (int i = 0; i < 9; i++)
		cout << heap[i] << ' ';


	return 0;
}
