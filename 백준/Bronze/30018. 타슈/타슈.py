import sys

input = sys.stdin.readline

n = int(input().rstrip())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

total = 0

for i in range(n):
    gap = a[i] - b[i]
    if 0 < gap:
        total += gap
print(total)