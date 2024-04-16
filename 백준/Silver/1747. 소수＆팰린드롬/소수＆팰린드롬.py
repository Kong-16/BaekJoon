import sys

input = sys.stdin.readline


def isPal(n):
    str_n = str(n)
    s = 0
    e = len(str_n) - 1
    while s < e:
        if str_n[s] != str_n[e]:
            return False
        s += 1
        e -= 1
    return True


def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


n = int(input().rstrip())
while True:
    if isPrime(n) and isPal(n):
        print(n)
        break
    n += 1