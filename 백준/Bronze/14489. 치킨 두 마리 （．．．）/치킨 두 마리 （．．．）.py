import sys

input = sys.stdin.readline

a, b = map(int, input().split())
c = int(input().rstrip())
s = a + b
if s < 2 * c:
    print(s)
else:
    print(s - 2 * c)