import sys

input = sys.stdin.readline

n = int(input().rstrip())

tot = n * (n - 1) // 2
print(tot)
print(2)