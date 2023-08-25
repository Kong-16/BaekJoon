import sys

input = sys.stdin.readline

n = int(input().strip())

scores = list(map(int, input().split()))

m = max(scores)

tot = 0
for s in scores:
    tot += s * 100 / m

print(tot / n)