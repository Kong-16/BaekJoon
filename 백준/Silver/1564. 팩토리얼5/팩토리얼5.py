import sys

input = sys.stdin.readline

n = int(input().strip())

ans = 1
for i in range(2, n + 1):
    ans *= i
    while ans % 10 == 0:
        ans //= 10
    ans %= 1000000000000

print("{:05d}".format(ans % 100000))