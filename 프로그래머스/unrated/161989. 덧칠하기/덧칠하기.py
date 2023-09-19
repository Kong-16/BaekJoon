def solution(n, m, section):
    answer = 0
    wall = [False for _ in range(n+1)]
    
    for i in section:
        wall[i] = True
    for w in range(1,n+1):
        if wall[w]:
            answer +=1
            for i in range(w,min(w+m,n+1)):
                wall[i] = False
                
    return answer