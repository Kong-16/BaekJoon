import sys
import math

input = sys.stdin.readline

a, b = map(int, input().split())
c, d = map(int, input().split())

dividened = a * d + b * c

divisor = b * d

g = math.gcd(dividened, divisor)

print(dividened // g, divisor // g, sep=" ")