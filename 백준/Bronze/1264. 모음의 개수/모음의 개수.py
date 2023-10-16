import sys

input = sys.stdin.readline

vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]

while True:
    try:
        str_inp = input().rstrip()
        if str_inp == '#':
            break
        cnt = 0
        for c in str_inp:
            if c in vowels:
                cnt += 1
        print(cnt)
    except:
        break