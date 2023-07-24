import sys

input = sys.stdin.readline

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

a, b, c = map(int, input().split())
abSum = abs(a) + abs(b)

if (abSum <= c) and (abSum % 2 == c % 2):
    print("YES")
else:
    print("NO")