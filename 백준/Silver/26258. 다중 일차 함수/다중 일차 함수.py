import sys

input = sys.stdin.readline


def binary_search(num):
    s = 0
    e = len(coord) - 1
    it = 0
    while s <= e:
        mid = (s + e) // 2
        if coord[mid][0] < num:
            s = mid + 1
        else:
            e = mid - 1
            it = mid
    return it


n = int(input().rstrip())

coord = []

for _ in range(n):
    coord.append(list(map(int, input().split())))

q = int(input().rstrip())

for _ in range(q):
    x = binary_search(float(input().rstrip()))
    if coord[x - 1][1] < coord[x][1]:
        print(1)
    elif coord[x][1] < coord[x - 1][1]:
        print(-1)
    else:
        print(0)