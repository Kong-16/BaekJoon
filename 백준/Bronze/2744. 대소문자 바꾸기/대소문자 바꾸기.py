import sys

input = sys.stdin.readline

inp_str = input().rstrip()
a = 97
z = 122
A = 65
Z = 90
gap = a - A
ans = ""
for c in inp_str:
    num = ord(c)
    if a <= num and num < z:
        num -= gap
    else:
        num += gap
    ans += chr(num)
print(ans)