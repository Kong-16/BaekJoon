import sys

input = sys.stdin.readline


def factorialize(n):
    arr = []
    while 1 < n:
        mul = 2
        while n % mul != 0:
            mul += 1
        arr.append(mul)
        n //= mul
    return arr


n = int(input().rstrip())

arr = sorted(factorialize(n))
for i in arr:
    print(i)