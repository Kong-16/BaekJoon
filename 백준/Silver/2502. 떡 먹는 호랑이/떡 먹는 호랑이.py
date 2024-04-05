import sys
import math

input = sys.stdin.readline

d, k = map(int, input().split())

fib = [1, 1]
for i in range(2, 50001):
    fib.append(fib[i - 2] + fib[i - 1])

for i in range(2, math.ceil(k // fib[d - 3])):
    for j in range(i, math.ceil(k // fib[d - 2])):
        if fib[d - 3] * i + fib[d - 2] * j == k:
            print(i)
            print(j)
            exit(0)