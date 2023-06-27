import sys

input = sys.stdin.readline

t = int(input().strip())

coins = [25, 10, 5, 1]
for _ in range(t):
    money = int(input().strip())
    idx = 0
    change = [0, 0, 0, 0]
    for i in range(4):
        change[i] = money // coins[i]
        money %= coins[i]
    print(*change)
