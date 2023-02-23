```
n, m = tuple(map(int, input().split()))

matrix = [
    [0] * n
    for _ in range(n)
]

dxs, dys = [0, 0, 1, -1], [1, -1, 0, 0]

def in_range(x, y):
    return (0 <= x and x < n) and (0 <= y and y < n)

for _ in range(m):
    x, y = tuple(map(int, input().split()))
    x, y = x-1, y-1
    matrix[x][y] = 1
    
    peace_cnt = 0
    for i in range(4):
        nx, ny = x + dxs[i], y + dys[i]
        if not in_range(nx, ny):
            continue
        if matrix[nx][ny] == 1:
            peace_cnt += 1
    print(1 if peace_cnt == 3 else 0)
```
