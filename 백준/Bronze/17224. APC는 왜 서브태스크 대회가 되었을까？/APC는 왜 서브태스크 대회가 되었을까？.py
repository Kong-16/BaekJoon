import sys

input = sys.stdin.readline

n, l, k = map(int, input().split())

easy = []
hard = []

for _ in range(n):
    e, h = map(int, input().split())
    easy.append((e, h))
    hard.append((h, e))

hard.sort(key=lambda x: x[0])

score = 0

for i in range(n):
    if 0 < k:
        if hard[i][0] <= l:
            score += 140
            k -= 1
        elif hard[i][1] <= l:
            score += 100
            k -= 1

print(score)