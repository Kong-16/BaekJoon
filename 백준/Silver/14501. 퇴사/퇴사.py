import sys

input = sys.stdin.readline

n = int(input())
meeting = [[] for _ in range(n + 10)]
# 퇴사일 이후로는 상담 불가하므로 -가중치 부여
dp = [-100000 for _ in range(n + 10)]
for i in range(1, n + 1):
    t, p = map(int, input().split())
    meeting[i] = [t, p]
    dp[i] = 0

# 1일 걸리는 상담의 경우 n+1일에 들어감. => n+1에 끝나는 것은 가능. 0으로 초기화
dp[n + 1] = 0

# 상담하고 p일 뒤에 또 하기 vs 오늘 상담 안하고 내일하기
for i in range(n, 0, -1):
    dp[i] = max(dp[i + meeting[i][0]] + meeting[i][1], dp[i + 1])

# 첫째 날 부터 일했을 때의 최댓값
print(dp[1])