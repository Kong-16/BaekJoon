import sys

input = sys.stdin.readline

m = int(input().rstrip())

s = set()

for _ in range(m):
    inp_str = input().rstrip()
    try:
        command, num = inp_str.split()
        if command == "add":
            s.add(num)
        elif command == "remove":
            s.remove(num)
        elif command == "check":
            print(int(num in s))
        elif command == "toggle":
            if num in s:
                s.remove(num)
            else:
                s.add(num)
    except:
        command = inp_str
        if command == "all":
            for i in range(1, 21):
                s.add(str(i))
        elif command == "empty":
            s.clear()