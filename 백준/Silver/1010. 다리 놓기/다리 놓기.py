import sys

input = sys.stdin.readline


def comb(a, b):
    res = 1
    for i in range(b):
        res *= a - i
        res //= i + 1
    return res


t = int(input().rstrip())

for _ in range(t):
    n, m = map(int, input().split())
    print(comb(m, n))