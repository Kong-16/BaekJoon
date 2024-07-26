import sys

input = sys.stdin.readline

n = int(input().rstrip())

org_a = []
for _ in range(n):
    org_a.append(input().rstrip())

ans = len(org_a[0])
for i in range(len(org_a[0])):
    s = set()
    for j in range(n):
        s.add(org_a[j][-i - 1 :])
    if len(s) == len(org_a):
        ans = i
        break

print(ans + 1)