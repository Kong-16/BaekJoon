import sys

input = sys.stdin.readline

n = int(input().rstrip())

print(int(bin(n)[:1:-1], 2))