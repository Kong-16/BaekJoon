import sys

input = sys.stdin.readline

i = 1
while True:
    a = input().rstrip()
    b = input().rstrip()
    if a == b and a == 'END':
        break
    print("Case {}: ".format(i), end="")
    i += 1
    if (sorted(a) == sorted(b)):
        print("same")
    else:
        print("different")