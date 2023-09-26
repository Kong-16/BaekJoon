import sys

input = sys.stdin.readline

a, b = map(int, input().split())

c = a + b

cnt = 0
for i in range(c + 1):
    for j in range(a + 1):
        for k in range(b + 1):
            if j + k == i:
                cnt += 1

print(cnt)