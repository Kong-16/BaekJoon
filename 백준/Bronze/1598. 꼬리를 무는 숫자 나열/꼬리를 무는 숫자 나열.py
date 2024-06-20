import sys
import math

input = sys.stdin.readline

a, b = map(int, input().split())

a_div = math.ceil(a / 4)
a_rem = (a - 1) % 4

b_div = math.ceil(b / 4)
b_rem = (b - 1) % 4

ans = abs(a_div - b_div) + abs(a_rem - b_rem)

print(ans)