import sys

input = sys.stdin.readline

n = input().strip()

if 2 < len(n):
    arr = n.split("10")
    ans = 0
    for i in arr:
        if len(i):
            ans += int(i)
        else:
            ans += 10
    if len(arr) == 3:
        ans -= 10
    print(ans)
else:
    print(int(n[0]) + int(n[1]))