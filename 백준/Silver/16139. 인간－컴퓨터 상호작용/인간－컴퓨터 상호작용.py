import sys

input = sys.stdin.readline

a = ord("a")
z = ord("z")


inp = input().rstrip()
alp = [[0 for _ in range(z - a + 1)]]

for i in range(1, len(inp) + 1):
    alp.append(alp[i - 1].copy())
    alp[i][ord(inp[i - 1]) - a] += 1


n = int(input().rstrip())


for _ in range(n):
    c, s, e = input().split()
    s = int(s)
    e = int(e)
    print(alp[e + 1][ord(c) - a] - alp[s][ord(c) - a])