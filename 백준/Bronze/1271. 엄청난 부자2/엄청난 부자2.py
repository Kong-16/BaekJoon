import sys

input = sys.stdin.readline
n, m = map(int, input().split())

q = n // m
print(q)
print(n - q * m)