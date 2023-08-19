import sys

input = sys.stdin.readline

inp_str = input().strip()
if eval(inp_str[0] + inp_str[2] + inp_str[4]) == int(inp_str[8]):
    print("YES")
else:
    print("NO")