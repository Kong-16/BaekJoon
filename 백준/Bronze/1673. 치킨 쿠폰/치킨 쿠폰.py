import sys

input = sys.stdin.readline

while True:
    try:
        n, k = map(int, input().split())
        cnt = n
        while k <= n:
            cnt += n // k
            n = n // k + n % k
        print(cnt)
    except:
        break