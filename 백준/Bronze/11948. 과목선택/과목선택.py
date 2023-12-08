import sys

input = sys.stdin.readline

sci = [0 for _ in range(4)]
soc = [0 for _ in range(2)]

for i in range(4):
    sci[i] = int(input().rstrip())
for i in range(2):
    soc[i] = int(input().rstrip())

tot = 0

print(sum(sorted(sci)[1:]) + max(soc))