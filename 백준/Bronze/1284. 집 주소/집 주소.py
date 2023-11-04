import sys

input = sys.stdin.readline

while True:
    inp_num = input().rstrip()
    if inp_num == '0':
        break
    tot = 1
    for i in inp_num:
        tot += 1
        if i == '1':
            tot += 2
        elif i == '0':
            tot += 4
        else:
            tot += 3
    print(tot)