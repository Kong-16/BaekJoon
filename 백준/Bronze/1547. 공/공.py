import math
import sys

input = sys.stdin.readline

cups = [False, True, False, False]
m = int(input().rstrip())

for _ in range(m):
    a, b = map(int, input().split())
    cups[a], cups[b] = cups[b], cups[a]

print(cups.index(True))