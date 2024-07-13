import sys
import collections

input = sys.stdin.readline

t = int(input().rstrip())

for _ in range(t):
    m = int(input().rstrip())
    dict = collections.defaultdict(set)
    for _ in range(m):
        cloth, category = input().split()
        dict[category].add(cloth)
    s = 1
    for v in dict.values():
        s *= len(v) + 1
    print(s - 1)