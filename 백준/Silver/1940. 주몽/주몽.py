import sys

input = sys.stdin.readline

n = int(input().strip())
m = int(input().strip())
ing = list(map(int, input().split()))
ing.sort()

cnt = 0
s = 0
e = len(ing) - 1
while s < e:
    tot = ing[s] + ing[e]
    if tot < m:
        s += 1
    elif m < tot:
        e -= 1
    else:
        cnt += 1
        s += 1
print(cnt)