import math
import sys

input = sys.stdin.readline

n = int(input().rstrip())

times = list(map(int, input().split()))

y_cost = 0
m_cost = 0

for t in times:
    y_cost += math.ceil((t + 1) / 30) * 10
    m_cost += math.ceil((t + 1) / 60) * 15

if y_cost < m_cost:
    print("Y {}".format(y_cost))
elif m_cost < y_cost:
    print("M {}".format(m_cost))
else:
    print("Y M {}".format(y_cost))