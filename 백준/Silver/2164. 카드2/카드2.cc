#include <iostream>
#include <queue>

using namespace std;

int main() {
	queue<int> q;

	int num;
	cin >> num;
	
	for (int i = 0; i < num; i++) {
		q.push(i + 1);
	}



	while (q.size() != 1) {
		q.pop();
		q.push(q.front());
		q.pop();
	}
	cout << q.front();
}