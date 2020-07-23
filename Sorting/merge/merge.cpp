#include <iostream>
#include <algorithm>
using namespace std;

int sorted[10];

void merge(int init[], int left, int mid, int right) {
	int i = left;
	int j = mid + 1;
	int k = left;


	while (i <= mid && j <= right) {
		if (init[i] <= init[j])
			sorted[k++] = init[i++];
		else
			sorted[k++] = init[j++];
	}

	if (i > mid){
		for (int t = j; t <= right; t++)
			sorted[k++] = init[t];
	}
	else {
		for (int t = i; t <= mid; t++)
			sorted[k++] = init[t];
	}

	for (int t = left; t <= right; t++)
		init[t] = sorted[t];
}

void mergeSort(int a[], int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;

		mergeSort(a, left, mid);
		mergeSort(a, mid + 1, right);
		merge(a, left, mid, right);
	}
}

int main() {
	int arry[10] = { 10, 4, 6, 3, 2, 7, 1, 9, 8, 5 };

	mergeSort(arry, 0, 9);

	for (int i = 0; i < 10; i++)
		cout << arry[i] << ' ';

	return 0;
}