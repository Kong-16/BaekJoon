import sys

input = sys.stdin.readline

n = int(input().rstrip())

alp = [0 for _ in range(26)]

a = ord("a")

for _ in range(n):
    inp = input().rstrip()
    alp[ord(inp[0]) - a] += 1

f = []
for i in range(len(alp)):
    if 5 <= alp[i]:
        f.append(chr(i + a))
if f:
    for c in f:
        print(c, end="")
else:
    print("PREDAJA")