import sys

input = sys.stdin.readline

k, n, m = map(int, input().split())
gap = k * n - m
print(gap if 0 < gap else 0)