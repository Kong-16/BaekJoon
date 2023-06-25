import sys

input = sys.stdin.readline

n = int(input().strip())

divisor = []
for i in range(1, int(n ** 0.5) + 1):
    if n % i == 0:
        divisor.append(i)
        if i * i != n:
            divisor.append(n // i)

ans = sum(divisor)
ans = (5 * ans) - 24
print(ans)