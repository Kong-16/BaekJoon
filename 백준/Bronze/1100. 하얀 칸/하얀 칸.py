import sys

input = sys.stdin.readline

n = 8
cnt = 0
for i in range(n):
    inp_str = input().rstrip()
    for j in range(n):
        if ((i + j) % 2 == 0 and inp_str[j] == 'F'):
            cnt += 1

print(cnt)