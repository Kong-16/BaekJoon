print(2)
prev = 2
while True:
    n = int(input().rstrip())
    if 99 <= n:
        break
    plus = 1
    if n % 3 == 1:
        plus = 2
    prev = n + plus
    print(prev)
    if 99 <= prev:
        break