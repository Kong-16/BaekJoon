import sys

input = sys.stdin.readline

n, k = map(int, input().split())

level = 1

while level < n:
    k //= 2
    level += 1

print(k)