import sys

input = sys.stdin.readline

fibbo = [0 for _ in range(100001)]

fibbo[1] = 1

for i in range(2, 100001):
    fibbo[i] = fibbo[i - 1] + fibbo[i - 2]

n = int(input().strip())
print(fibbo[n])