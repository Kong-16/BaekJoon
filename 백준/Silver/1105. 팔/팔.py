import sys

input = sys.stdin.readline

l, r = input().split()

cnt = 0

if len(l) != len(r):
    cnt = 0
else:
    length = len(l)
    for i in range(length):
        if l[i] == r[i]:
            if l[i] == "8":
                cnt += 1
            else:
                continue
        else:
            break
print(cnt)