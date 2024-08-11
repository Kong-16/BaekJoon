import sys

input = sys.stdin.readline

n = int(input().rstrip())

f = "I" + "OI" * n

m = int(input().rstrip())

inp = input().rstrip()

cnt = 0
for i in range(m):
    if inp[i : i + len(f)] == f:
        cnt += 1

print(cnt)