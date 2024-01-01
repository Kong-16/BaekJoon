import sys
import math

input = sys.stdin.readline

n, m = map(int, input().split())

set_cost = 10000
single_cost = 10000

for _ in range(m):
    a, b = map(int, input().split())
    set_cost = min(a, set_cost)
    single_cost = min(b, single_cost)

set_buy = n // 6
single_buy = n % 6

print(min(((set_buy + 1) * set_cost, set_buy * set_cost + single_buy * single_cost, n * single_cost)))