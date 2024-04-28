import sys

input = sys.stdin.readline

t = 1
while True:
    l, p, v = map(int, input().split())
    if l + p + v == 0:
        break
    ans = (v // p) * l
    if v % p != 0:
        ans += min(l, v % p)
    print("Case {}: {}".format(t, ans))
    t += 1