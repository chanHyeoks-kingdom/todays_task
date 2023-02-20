

# method1: 벽을 마주쳤을 땐, in_range
# method2: 방향을 우측으로 90도 회전키 위해 (direction_idx +1) % 4
# method3: nx로 미리 다음 노드 탐색하고, 방향 전환 필요하면 전환한 다음에 x, y에는 새 위치로 나아가는 방식

n, m = tuple(map(int, input().split()))
x, y = 0, 0

matrix = [
    [0] * m
    for _ in range(n)
]

dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

def in_range(x, y):
    return (0 <= x and x < n) and (0 <= y and y < m)

direction_idx = 0

matrix[x][y] = 1

for i in range(2, n*m + 1):
    nx, ny = x + dxs[direction_idx], y + dys[direction_idx]

    if not in_range(nx, ny) or matrix[nx][ny] != 0:
        direction_idx = (direction_idx + 1) % 4
    
    x, y = x + dxs[direction_idx], y + dys[direction_idx]
    matrix[x][y] = i


for i in range(n):
    for j in range(m):
        print(matrix[i][j], end = ' ')
    print()
