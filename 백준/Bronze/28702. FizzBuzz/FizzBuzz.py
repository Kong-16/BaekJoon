import sys

input = sys.stdin.readline

ans = 0
for i in range(3):
    num = input().rstrip()
    if num.isdigit():
        ans = int(num) + 3 - i

if not ans % 3:
    if not ans % 5:
        print("FizzBuzz")
    else:
        print("Fizz")
elif not ans % 5:
    print("Buzz")
else:
    print(ans)