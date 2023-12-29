import sys

input = sys.stdin.readline

n = int(input().rstrip())

arr = [int(input().rstrip()) for _ in range(n)]

arr.sort(reverse=True)

money = 0
for i in range(n):
    plus = arr[i] - i
    money += plus if 0 < plus else 0

print(money)