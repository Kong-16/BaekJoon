import sys
import datetime

input = sys.stdin.readline

a, b = map(int, input().split())

x = datetime.date(2007, a, b)

days = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"]
print(days[x.weekday()])