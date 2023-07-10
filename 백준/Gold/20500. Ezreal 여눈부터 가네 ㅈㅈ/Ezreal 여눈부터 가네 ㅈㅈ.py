import sys

input = sys.stdin.readline

divisor = 1000000007


def choose(a, b):
    (a, b) = (b, a) if a < b else (a, b)
    total = 1
    for i in range(1, b + 1):
        total *= (a + 1 - i)
        total //= i
    return total


n = int(input().strip())

one = n - 1
five = 0
cnt = 0
for i in range(n):
    if (one + (five * 5) + 5) % 3 == 0:
        cnt += choose(n - 1, i)
    one -= 1
    five += 1
print(cnt % divisor)