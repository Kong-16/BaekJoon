import sys

input = sys.stdin.readline

n = int(input().rstrip())

name = set()
cnt = 0
for _ in range(n):
    inp_str = input().rstrip()
    if inp_str == "ENTER":
        name = set()
    elif inp_str not in name:
        cnt += 1
        name.add(inp_str)

print(cnt)