import sys

input = sys.stdin.readline

while True:
    try:
        s, e = map(int, input().split())
        cnt = 0
        for number in range(s, e + 1):
            digit = [0 for _ in range(10)]
            flag = True
            while number:
                if 0 != digit[number % 10]:
                    flag = False
                    break
                digit[number % 10] += 1
                number //= 10
            if flag:
                cnt += 1
        print(cnt)
    except:
        break