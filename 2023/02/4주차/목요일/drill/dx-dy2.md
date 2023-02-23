#### dx-dy(2): 방향 회전을 위한 dx, dy 정의 방법

다음 문제는 어떻게 풀어볼 수 있을까요?

(1, 5) 위치에서 시작하며 현재 북쪽을 바라보고 있습니다. 

방향을 시계방향으로 90' 회전한 후, 
앞으로 한 칸 이동한 이후의 위치를 구해보세요.
dx, dy 테크닉을 이용해 이 문제를 해결해 보겠습니다.
먼저 다음과 같이 dx, dy를 정의했다고 생각해보겠습니다.



그러면 문제에서 원하는 코드는 다음과 같이 작성해볼 수 있습니다.

dir_num = 3 
x, y = 1, 5
dx, dy = [1, -1, 0, 0], [0, 0, -1, 1]

# rotate direction
if dir_num == 0:
    dir_num = 2
elif dir_num == 1:
    dir_num = 3
elif dir_num == 2:
    dir_num = 1
else:
    dir_num = 0

# move
nx, ny = x + dx[dir_num], y + dy[dir_num]
방향을 바꾸는 코드가 조금 복잡해보이네요. 만약 dx, dy를 다음과 같이 시계 방향 순서대로 정의를 하면 코드가 어떻게 달라질까요?



먼저 위에 코드에서 방향 변화에 대한 코드가 달라집니다.

dir_num = 3 
x, y = 1, 5
dx, dy = [1, 0, -1, 0], [0, -1, 0, 1]

# rotate direction
if dir_num == 0:
    dir_num = 1
elif dir_num == 1:
    dir_num = 2
elif dir_num == 2:
    dir_num = 3
else:
    dir_num = 0

# move
nx, ny = x + dx[dir_num], y + dy[dir_num]
dx, dy에서 방향 번호를 시계방향 순서대로 적어 넣었다 보니, 결국 시계방향으로 90' 회전을 하는 것은 dir_num을 1 증가시키는 것만으로 가능하다는 것을 알 수 있습니다. 다만 dir_num이 3인 경우에는 다시 0이 되어야 하므로 현재 방향이 dir_num이었다면 시계방향으로 90' 회전한 이후의 방향은 (dir_num + 1) % 4 임을 알 수 있습니다.



따라서 다음과 같이 코드 변경이 가능합니다.

dir_num = 3 
x, y = 1, 5
dx, dy = [1, 0, -1, 0], [0, -1, 0, 1]

# rotate direction
dir_num = (dir_num + 1) % 4

# move
nx, ny = x + dx[dir_num], y + dy[dir_num]
Side Note
반시계 방향에 대한 회전은, 현재 dir_num에서 1을 빼주면 됩니다.
다만 이 경우 dir_num이 0일때 다시 3이 되어야 하므로,
그 다음 dir_num을 (dir_num + 3) % 4로 설정하는 것이 좋습니다.
(dir_num - 1) % 4로 진행할 경우, dir_num이 0일 때 -1 % 4는 사용하는 언어에 따라 -1 값을 갖게 되는 경우도 있기 때문에 사용하지 않는 것을 권장합니다.

즉, 반시계 방향으로 90' 회전은 다음 식으로 표현이 가능합니다.

dir_num = (dir_num - 1 + 4) % 4
이렇게 방향이 항상 양수 값을 갖도록 만들어 주는 것이 중요합니다.
