import sys

input = sys.stdin.readline

n = int(input().rstrip())

for _ in range(n):
    a, b, x = map(int, input().split())
    print(a * (x - 1) + b)