import sys

input = sys.stdin.readline

n = input().strip()

cnt = 0
while 1 < len(n):
    sum = 0
    cnt += 1
    for i in n:
        sum += int(i)
    n = str(sum)
print(cnt)
if int(n) % 3 == 0:
    print("YES")
else:
    print("NO")