import sys
import collections

input = sys.stdin.readline

a, b = map(int, input().split())

d = collections.defaultdict(list)

for _ in range(a):
    inp = input().rstrip()
    if b <= len(inp):
        if d[inp]:
            d[inp][1] += 1
        else:
            d[inp] = [len(inp), 1]

arr = []

for k, v in d.items():
    v.append(k)
    arr.append(v)

arr.sort(key=lambda x: (-x[1], -x[0], x[2]))

for i in arr:
    print(i[2])