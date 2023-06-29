import sys

input = sys.stdin.readline

n = int(input().strip())

for _ in range(2):
    for _ in range(n):
        for _ in range(n):
            print('@', end="")
        for _ in range(3 * n):
            print(" ", end="")
        for _ in range(n):
            print('@', end="")
        print()

    for _ in range(n):
        for _ in range(n):
            print('@@@@@', end="")
        print()
for _ in range(n):
    for _ in range(n):
        print('@', end="")
    for _ in range(3 * n):
        print(" ", end="")
    for _ in range(n):
        print('@', end="")
    print()
