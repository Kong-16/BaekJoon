import sys

input = sys.stdin.readline

s, t, d = map(int, input().split())

print(d // (2 * s) * t)