import sys

input = sys.stdin.readline

n = int(input().rstrip())
num = n
cnt = 0

while cnt == 0 or num != n:
    tmp = num % 10 + num // 10
    num = tmp % 10 + (num % 10) * 10
    cnt += 1

print(cnt)