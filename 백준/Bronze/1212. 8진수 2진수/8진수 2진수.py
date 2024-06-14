import sys

input = sys.stdin.readline

n = input().rstrip()
sn = int(n, 8)
result = format(sn, "b")
print(result)