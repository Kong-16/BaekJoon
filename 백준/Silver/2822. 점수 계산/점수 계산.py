import sys

input = sys.stdin.readline

n = 8
arr = []

for i in range(n):
    inp = int(input().rstrip())
    arr.append([inp, i + 1])

arr.sort(key=lambda x: x[0], reverse=True)

tot = 0
ans = []
for i in range(5):
    tot += arr[i][0]
    ans.append(arr[i][1])

ans.sort()
print(tot)
print(*ans)