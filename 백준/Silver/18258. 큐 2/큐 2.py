import sys
import collections

input = sys.stdin.readline

n = int(input().rstrip())

queue = collections.deque()

for _ in range(n):
    command = input().rstrip()
    if "push" in command:
        queue.append(command.split()[1])
    if command == "pop":
        if queue:
            print(queue.popleft())
        else:
            print(-1)
    if command == "size":
        print(len(queue))
    if command == "empty":
        if queue:
            print(0)
        else:
            print(1)
    if command == "front":
        if queue:
            tmp = queue.popleft()
            print(tmp)
            queue.appendleft(tmp)
        else:
            print(-1)
    if command == "back":
        if queue:
            tmp = queue.pop()
            print(tmp)
            queue.append(tmp)
        else:
            print(-1)