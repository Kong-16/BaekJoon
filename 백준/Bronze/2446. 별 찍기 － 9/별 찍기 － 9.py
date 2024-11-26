import sys

input = sys.stdin.readline

n = int(input().rstrip())

for i in range(1, 2 * n):
    k = abs(i - n) * 2
    for j in range((2 * n - k) // 2 - 1):
        print(" ", end="")
    for w in range(k + 1):
        print("*", end="")
    print("")