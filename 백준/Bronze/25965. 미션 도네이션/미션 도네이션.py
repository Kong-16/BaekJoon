import sys

input = sys.stdin.readline

n = int(input().strip())

for _ in range(n):
    m = int(input().strip())
    missions = [[] for _ in range(m)]
    for i in range(m):
        missions[i] = list(map(int, input().split()))
    k, d, a = map(int, input().split())
    total = 0
    for i in range(m):
        sum = (k * missions[i][0]) - (d * missions[i][1]) + (a * missions[i][2])
        if 0 < sum:
            total += sum
    print(total)