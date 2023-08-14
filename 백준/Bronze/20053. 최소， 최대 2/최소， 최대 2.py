import sys
from collections import deque

input = sys.stdin.readline

t = int(input().strip())
for _ in range(t):
    n = int(input().strip())
    inp = list(map(int, input().split()))
    print("{} {}".format(min(inp), max(inp)))