import sys

input = sys.stdin.readline


def isPrime(num):
    for i in range(2, int(num**0.5) + 1):
        if not num % i:
            return False
    return True


a = ord("a")
A = ord("A")

tot = 0

inp = input().rstrip()
for i in inp:
    c = ord(i)
    if c < a:
        tot += c - 38
    else:
        tot += c - 96

print("It is a prime word." if isPrime(tot) else "It is not a prime word.")