import sys

input = sys.stdin.readline

n = int(input())

ans = 1;
for i in range(n, 0, -1):
    ans = ans * i

print(ans)