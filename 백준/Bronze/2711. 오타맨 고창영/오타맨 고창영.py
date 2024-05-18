import sys

input = sys.stdin.readline

t = int(input().rstrip())

for _ in range(t):
    n, inp = input().split()
    print(inp[: int(n) - 1] + inp[int(n) :])