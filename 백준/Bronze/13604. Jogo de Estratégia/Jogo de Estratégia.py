import sys

input = sys.stdin.readline

j, r = map(int, input().split())

players = [0 for _ in range(j)]

points = list(map(int, input().split()))

for i in range(j * r):
    players[i % j] += points[i]

max_idx = -1
max_num = -1
for i in range(j):
    if max_num <= players[i]:
        max_num = players[i]
        max_idx = i

print(max_idx + 1)