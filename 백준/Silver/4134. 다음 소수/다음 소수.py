import sys

input = sys.stdin.readline


def isPrime(n):
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    if n < 2:
        print(2)
        continue
    while not isPrime(n):
        n += 1
    print(n)