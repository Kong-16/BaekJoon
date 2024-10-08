import sys

input = sys.stdin.readline

r = int(input().rstrip())
c = int(input().rstrip())

for _ in range(r):
    for _ in range(c):
        print("*", end="")
    print()