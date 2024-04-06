import sys

input = sys.stdin.readline

n = int(input().rstrip())

cow = []
for i in range(n):
    cow.append(list(map(int, input().split())))

cow.sort(key=lambda x: x[0])

time = -1

for arrive, cost in cow:
    time = max(time, arrive) + cost

print(time)