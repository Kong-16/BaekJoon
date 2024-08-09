import sys

input = sys.stdin.readline

d, h, w = map(int, input().split())

x = d / (h**2 + w**2) ** 0.5

print(int(x * h), int(x * w))