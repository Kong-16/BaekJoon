import sys

input = sys.stdin.readline

n = int(input().rstrip())

ropes = [0 for _ in range(n)]

for i in range(n):
    ropes[i] = int(input().rstrip())

ropes.sort(reverse=True)

mul = 1
max_weight = 0
for i in range(n):
    max_weight = max(max_weight, ropes[i] * (i + 1))

print(max_weight)