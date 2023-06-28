import sys

input = sys.stdin.readline

n = int(input().strip())
for _ in range(n):
    l = int(input().strip())
    for _ in range(l):
        print('=', end="")
    print()