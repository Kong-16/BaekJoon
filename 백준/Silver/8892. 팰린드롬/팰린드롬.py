import sys

input = sys.stdin.readline


def isPal(word):
    s = 0
    e = len(word) - 1
    while s <= e:
        if word[s] != word[e]:
            return False
        s += 1
        e -= 1
    return True


t = int(input().rstrip())

for _ in range(t):
    n = int(input().rstrip())
    arr = []
    ans = ""
    for _ in range(n):
        arr.append(input().rstrip())
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            new_word = arr[i] + arr[j]
            if isPal(new_word):
                ans = new_word
    print(ans if len(ans) else 0)