import sys
import math

input = sys.stdin.readline

n, m = map(int, input().split())
t, s = map(int, input().split())

work_time = 8

zip_time = (math.ceil(n / work_time) - 1) * s + n
dok_time = (math.ceil(m / work_time) - 1) * (s + 2 * t) + t + m

if zip_time < dok_time:
    print("Zip")
    print(zip_time)
else:
    print("Dok")
    print(dok_time)