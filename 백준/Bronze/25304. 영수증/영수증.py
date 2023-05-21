import sys

input = sys.stdin.readline

total = int(input())

n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    total -= (a * b)

if total == 0:
    print("Yes")
else:
    print("No")