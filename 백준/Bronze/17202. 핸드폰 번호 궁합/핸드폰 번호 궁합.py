import sys

input = sys.stdin.readline

n = input().rstrip()
m = input().rstrip()

s = ""
for i in range(len(n)):
    s += n[i] + m[i]


while 2 < len(s):
    comb = ""
    for i in range(len(s) - 1):
        comb += str(int(s[i]) + int(s[i + 1]))[-1]
    s = comb

print("{:02}".format(s))
