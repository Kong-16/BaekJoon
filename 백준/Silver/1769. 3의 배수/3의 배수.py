import sys

input = sys.stdin.readline

n = int(input())

cnt = 0
while 10 <= n:
    sum = 0
    cnt += 1
    nStr = str(n)
    for i in nStr:
        sum += int(i)
    n = sum
print(cnt)
print("YES" if n % 3 == 0 else "NO")