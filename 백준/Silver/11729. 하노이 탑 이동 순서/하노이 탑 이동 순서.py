import sys

input = sys.stdin.readline

n = int(input().strip())


def hanoi(n, f, m, t):
    if n == 1:
        print("{} {}".format(f, t))
        return
    hanoi(n - 1, f, t, m)
    print("{} {}".format(f, t))
    hanoi(n - 1, m, f, t)


print(2 ** n - 1)
hanoi(n, 1, 2, 3)