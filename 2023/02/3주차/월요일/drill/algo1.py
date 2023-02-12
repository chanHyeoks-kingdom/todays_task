
# A와 B가 동일한 시작점에서 같은 방향으로 출발합니다. 도중에 방향을 바꾸는 경우는 없고, A, B는 각각 N번, M번에 걸쳐 주어지는 특정 속도로 특정 시간만큼 이동한다고 합니다. 선두가 몇번이 바뀌는지 찾아 출력하는 프로그램을 작성해보세요.

# 입력 형식
# 첫 번째 줄에 N과 M이 주어집니다.

# 두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 A가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.

# 그 다음 줄부터는 M개의 줄에 걸쳐 각 줄마다 B가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.

# A가 총 이동한 시간과 B가 총 이동한 시간은 항상 동일하게 주어짐을 가정해도 좋습니다.

# 1 ≤ N, M ≤ 1,000
# 0 ≤ v, t ≤ 1,000
# 출력 형식
# 첫 번째 줄에 선두가 몇 번 바뀌는지 출력합니다.

# 입출력 예제
# 예제1
# 입력:

# 4 3
# 1 2
# 4 1
# 1 1
# 2 10
# 2 3
# 1 2
# 3 9
# 출력:

# 2


MAX_R = 1000001

position_a = [0] * MAX_R
position_b = [0] * MAX_R

n, m = tuple(map(int, input().split()))

time_a = 1
for _ in range(n):
    distance, time = tuple(map(int, input().split()))
    for _ in range(time):
        position_a[time_a] = position_a[time_a-1] + distance
        time_a += 1

time_b = 1
for _ in range(m):
    distance, time = tuple(map(int, input().split()))
    for _ in range(time):
        position_b[time_b] = position_b[time_b-1] + distance
        time_b += 1

leader, answer = 0, 0
for i in range(1, len(position_a)):
    if position_a[i] > position_b[i]:
        if leader == 2:
            answer += 1
        leader = 1

    elif position_a[i] < position_b[i]:
        if leader == 1:
            answer += 1
        leader = 2

print(answer)
