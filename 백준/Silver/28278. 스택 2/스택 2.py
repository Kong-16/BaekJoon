import sys
import collections

input = sys.stdin.readline

n = int(input().rstrip())
stack = collections.deque()
for _ in range(n):
    inp_str = input().rstrip()
    try:
        command, num = map(int, inp_str.split())
        stack.append(num)
    except:
        command = inp_str
        if command == "2":
            if stack:
                print(stack.pop())
            else:
                print(-1)
        elif command == "3":
            print(len(stack))
        elif command == "4":
            if stack:
                print(0)
            else:
                print(1)
        elif command == "5":
            if stack:
                print(stack[-1])
            else:
                print(-1)