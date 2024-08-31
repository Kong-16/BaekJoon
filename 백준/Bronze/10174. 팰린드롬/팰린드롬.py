import sys

input = sys.stdin.readline


def isPal(inp):
    s = 0
    e = len(inp) - 1
    while s <= e:
        if inp[s] != inp[e]:
            return False
        s += 1
        e -= 1
    return True


t = int(input().rstrip())

for _ in range(t):
    print("Yes" if isPal(input().strip().upper()) else "No")