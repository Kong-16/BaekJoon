import sys

input = sys.stdin.readline

n = int(input().rstrip())

cnt = 0
a_num = ord('a')
alp_num = ord('z') - a_num + 1

for test_case in range(n):
    alph = [True for _ in range(alp_num)]
    inp_str = input().rstrip()
    flag = True
    prev = -1
    for c in inp_str:
        num = ord(c) - a_num
        if num != prev:
            if alph[num]:
                alph[num] = False
                prev = num
            else:
                flag = False
                break
    if flag:
        cnt += 1
print(cnt)