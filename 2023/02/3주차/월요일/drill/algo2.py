# 학생이 N명 있습니다. 각 학생은 1번부터 N번까지 번호가 붙여져 있으며, 만약 한 학생이 K번 이상 벌칙을 받게 되면 벌금을 내야 합니다. M번에 걸쳐 벌칙에 걸린 학생의 번호가 순서대로 주어질때, 최초로 벌금을 내게 되는 학생이 누구인지를 알아내는 프로그램을 작성해보세요.

# 입력 형식
# 첫 번째 줄에 N, M, 그리고 K가 공백을 사이에 두고 주어집니다.

# 두 번째 줄부터는 M개의 줄에 걸쳐 각 학생의 번호가 한 줄에 하나씩 순서대로 주어집니다.

# 1 ≤ N ≤ 100
# 1 ≤ K, M ≤ 10,000
# 1 ≤ 학생의 번호 ≤ N
# 출력 형식
# 첫 번째 줄에 최초로 벌금을 내게 되는 학생의 번호를 출력합니다. 만약 M번이 지났는데도 벌금을 내게 되는 학생이 없다면, -1을 출력합니다.

# 입출력 예제
# 예제1
# 입력:

# 5 7 3
# 2
# 5
# 2
# 3
# 5
# 2
# 4
# 출력:

# 2


# 학생수: n
# 학생 번호: 1~ n
# 벌금 기준: 벌칙 k회

# M번에 걸쳐 벌칙 걸린 학생의 번호 주어짐

penalty_students_number = []
n, m, k = tuple(map(int, input().split()))

penalty_student_history = [
    int(input())
    for _ in range(m)
]

students_number =[0] * (n+1)


answer = -1

for student_id in penalty_student_history:
    students_number[student_id] += 1

    if students_number[student_id] == k:
        answer = student_id
        break

print(answer)

