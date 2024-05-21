import sys

input = sys.stdin.readline

n = int(input().rstrip())
org = n
num = 1
cnt = 0
tot = 0
i = 1

while n // 10:
    cnt += 9 * (10 ** (num - 1))
    tot += 9 * (10 ** (num - 1)) * num
    num += 1
    n = n // 10

tot += num * (org - cnt)
print(tot)