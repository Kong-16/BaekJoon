import sys

input = sys.stdin.readline


def hi(a, b):
    if a < b:
        a, b = b, a
    if a // b == a / b:
        return True
    return False


while True:
    a, b = map(int, input().split())
    if not a * b:
        break
    if hi(a, b):
        if a < b:
            print("factor")
        else:
            print("multiple")
    else:
        print("neither")