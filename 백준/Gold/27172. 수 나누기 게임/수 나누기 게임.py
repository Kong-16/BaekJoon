import sys

input = sys.stdin.readline

n = int(input())
N_MAX = 1000001
players = list(map(int, input().split()))

eratosthenes = [False] * N_MAX
ans = [0] * N_MAX

for i in players:
    eratosthenes[i] = True

for i in sorted(players):
    for j in range(i * 2, N_MAX, i):
        if eratosthenes[j]:
            ans[i] += 1
            ans[j] -= 1

print(*[ans[i] for i in players])