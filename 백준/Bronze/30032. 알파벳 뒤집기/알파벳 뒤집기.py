import sys

input = sys.stdin.readline

num = {"d": 0, "b": 1, "q": 2, "p": 3}
alp = [["d", "q", "b"], ["b", "p", "d"], ["q", "d", "p"], ["p", "b", "q"]]

n, d = map(int, input().split())
ans = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    inp = input().rstrip()
    for j in range(n):
        ans[i][j] = alp[num[inp[j]]][d]
for i in range(n):
    for j in range(n):
        print(ans[i][j], end="")
    print()