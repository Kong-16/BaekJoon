import sys

input = sys.stdin.readline

sys.setrecursionlimit(10 ** 5)

n = int(input().strip())
print(n * (n - 1) // 2)