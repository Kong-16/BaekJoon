import sys

input = sys.stdin.readline

n = int(input().rstrip())

a, b = map(int, input().split())

tot = a // 2 + b
print(min(n, tot))