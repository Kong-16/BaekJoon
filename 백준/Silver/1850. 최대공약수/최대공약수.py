import sys
import math

input = sys.stdin.readline

a, b = map(int, input().split())

n = math.gcd(a, b)

for _ in range(n):
    print(1, end="")