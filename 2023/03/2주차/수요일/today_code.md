
```

n, m = map(int, input())
matrix = [
    input().split()
    for _ in range(n)
]

dxs ,dys = [0, 1, 0, -1, 1, 1, -1, -1], [1, 0, -1, 0, 1, -1, -1, 1]
dir_index = 0

def in_range(x, y):
    return (0 <= x and x < n) and (0 <= y and y < n)


expected_start_idx = []

for i in n:
    for j in m:
        if matrix[i][j] == 'L':
            expected_start_idx.append(i, j)

answer = 0
for i, j in expected_start_idx:
    step = 0
    is_lee_check = True
    for _ in range(8):
        while step < 3:
            j = j + dxs[dir_index]
            i = i + dys[dir_index]
            if in_range(i, j):
                continue

            if matrix[i][j] != 'E':
                is_lee_check = False

            if is_lee_check == True:
                answer += 1

            is_lee_check = True 
            step += 1
        step = 0
        dir_index += 1
    dir_index = 0




```
