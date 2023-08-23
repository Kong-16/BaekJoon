import sys

input = sys.stdin.readline
n, k = map(int, input().split())

mul = 1
for div in range(1, k + 1):
    mul *= n + 1 - div
    mul //= div

print(mul % 10007)