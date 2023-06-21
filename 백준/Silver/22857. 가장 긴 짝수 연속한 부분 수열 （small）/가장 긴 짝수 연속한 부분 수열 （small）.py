import sys
from collections import deque

input = sys.stdin.readline

n, k = map(int, input().split())

sequence = list(map(int, input().split()))

s = 0
e = 0
maxCnt = 0
# 홀수, 짝수의 위치 각각 저장
odd = deque()
even = deque()

while e < len(sequence):
    # 홀수일 경우 삭제
    if sequence[e] % 2 == 1:
        odd.append(e)
        # k개 보다 많이 삭제한 상황이면 가장 앞의 수 삭제 => 그 보다 전에 있던 짝수들은 모두 뺌
        if (k < len(odd)):
            maxCnt = max(maxCnt, len(even))
            f = odd.popleft()
            while (even and even[0] < f):
                even.popleft()
    else:
        even.append(e)
    e += 1

print(max(maxCnt, len(even)))