import sys

input = sys.stdin.readline

n = int(input().rstrip())
while True:
    k = int(input().rstrip())
    if k == 0:
        break
    print(k, end=" ")
    if k % n == 0:
        print("is a multiple of {}.".format(n))
    else:
        print("is NOT a multiple of {}.".format(n))