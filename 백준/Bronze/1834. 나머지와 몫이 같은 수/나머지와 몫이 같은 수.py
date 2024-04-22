import sys

input = sys.stdin.readline

n = int(input().rstrip())
sum = 0
for i in range(1, n):
    sum += i * n + i

print(sum)