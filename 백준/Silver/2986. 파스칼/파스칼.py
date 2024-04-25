import sys

input = sys.stdin.readline

n = int(input().rstrip())

cnt = 1

for i in range(2, int(n**0.5) + 1):
    if n % i == 0:
        cnt = n // i
        break

print(n - cnt)