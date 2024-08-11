import sys

input = sys.stdin.readline


def count_zero(num):
    z = 0
    while 5 <= num:
        z += num // 5
        num //= 5
    return z


m = int(input().rstrip())

ans = 0
s, e = 0, m * 5
while s <= e:
    mid = (s + e) // 2

    z = count_zero(mid)
    if z < m:
        s = mid + 1
    else:
        e = mid - 1
        ans = mid
print(ans if count_zero(ans) == m else -1)