import sys

input = sys.stdin.readline

n, k = map(int, input().split())

dividend = []
for i in range(1, int(n ** 0.5) + 1):
    if n % i == 0:
        dividend.append(i)
        if i * i != n:
            dividend.append(n // i)

print(sorted(dividend)[k - 1] if k <= len(dividend) else 0)