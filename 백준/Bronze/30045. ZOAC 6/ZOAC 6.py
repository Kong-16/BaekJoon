import sys

input = sys.stdin.readline

n = int(input().rstrip())
cnt = 0
for _ in range(n):
    inp_str = input().rstrip()
    length = len(inp_str)
    for i in range(length):
        if (inp_str[i] == "0" and i + 1 < length and inp_str[i + 1] == "1") or (
                inp_str[i] == "O" and i + 1 < length and inp_str[i + 1] == "I"):
            cnt += 1
            break
print(cnt)