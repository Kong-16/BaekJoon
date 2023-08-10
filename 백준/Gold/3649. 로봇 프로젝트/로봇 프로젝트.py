import sys

input = sys.stdin.readline

while True:
    try:
        x = int(input().strip()) * (10 ** 7)
    except:
        break
    n = int(input().strip())
    legos = sorted([int(input().strip()) for _ in range(n)])
    msg = "danger"
    s = 0
    e = len(legos) - 1
    while s < e:
        tot = legos[s] + legos[e]
        if tot < x:
            s += 1
        elif x < tot:
            e -= 1
        else:
            msg = "yes {} {}".format(legos[s], legos[e])
            break
    print(msg)