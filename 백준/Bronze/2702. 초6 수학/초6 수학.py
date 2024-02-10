import sys
import math

input = sys.stdin.readline

n = int(input().rstrip())

for _ in range(n):
    a, b = map(int, input().split())
    print("{} {}".format(math.lcm(a, b), math.gcd(a, b)))