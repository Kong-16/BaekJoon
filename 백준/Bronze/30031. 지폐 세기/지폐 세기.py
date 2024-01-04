import sys

input = sys.stdin.readline

n = int(input().rstrip())

money_sum = 0
moneys = {"136": 1000, "142": 5000, "148": 10000, "154": 50000}
for _ in range(n):
    a, b = input().split()
    money_sum += moneys[a]
print(money_sum)