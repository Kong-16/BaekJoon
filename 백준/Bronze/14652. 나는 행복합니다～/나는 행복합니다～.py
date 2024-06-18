import sys

input = sys.stdin.readline

n, m, k = map(int, input().split())

t = 0
for i in range(n):
    for j in range(m):
        if t == k:
            print("{} {}".format(i, j))
            exit(0)
        t += 1