import sys

input = sys.stdin.readline

n = int(input().rstrip())
arr = list(map(int, input().split()))
stack = []
stack.append(-1)
idx = 0
up = True

while idx < n:
    if up and stack[-1] < arr[idx]:
        stack.append(arr[idx])
        idx += 1
    elif up and arr[idx] < stack[-1]:
        up = False
    elif not up and arr[idx] < stack[-1]:
        stack.append(arr[idx])
        idx += 1
    else:
        break

print("YES" if idx == n else "NO")