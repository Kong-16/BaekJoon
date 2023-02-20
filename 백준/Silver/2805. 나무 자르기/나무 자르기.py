import sys

input = sys.stdin.readline

N, M = map(int, input().split())
tree = list(map(int, input().split()))

tree.sort()

start, end = 0, tree[-1]

while start <= end:
    mid = (end + start) // 2
    sum_wood = 0
    for i in range(0, len(tree)):
        cut = tree[i] - mid
        if cut > 0:
            sum_wood += cut
    if sum_wood < M:
        end = mid - 1
    elif sum_wood >= M:
        answer = mid
        start = mid + 1

print(answer)
