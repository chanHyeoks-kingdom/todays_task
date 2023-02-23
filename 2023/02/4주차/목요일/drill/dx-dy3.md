### dx-dy(3)

다음 문제는 어떻게 풀어볼 수 있을까요?

5 * 5 크기의 격자가 주어집니다.

0 0 0 1 0
0 1 1 1 0
0 0 0 0 1
1 0 1 1 1
1 0 1 1 0

(3행, 2열) 위치의 인접한 상하좌우 칸에 숫자 1이 몇 개 있나요?
격자는 2차원 배열로 표현할 수 있습니다. 이때, 편의상 0번 index부터 사용하여 격자를 표현해보면 다음과 같습니다.

i/j   0 1 2 3 4
  ---------------
0|    0 0 0 1 0
1|    0 1 1 1 0
2|    0 0 0 0 1
3|    1 0 1 1 1
4|    1 0 1 1 0
만약 격자가 a라는 이름의 2차원 배열로 표현이 되고 있었다면, 3행 2열에 해당하는 값은 a[2][1]에 들어있었을 것입니다. 즉, 3행 2열은 0번 index부터 시작한 격자에서는 행 열에 각각 1씩 빼준 (2, 1) 위치에 들어있게 됩니다.

격자에서 역시 dx, dy 테크닉을 이용하면, 인접한 상하좌우의 위치를 쉽게 구할 수 있습니다.
다만, 여기서 유의해야할 점은 격자에서의 x, y를 수학에서의 x, y가 아닌 행, 열로 생각해야 한다는 것입니다.

(x, y)의 의미를 x행 y열로 생각하면, 다음과 같이 dx, dy를 정의할 수 있습니다.



오른쪽 방향은 열이 증가하는 방향이므로 y값이 +1이 되며, 아래 방향은 행이 증가하는 방향이므로 x값이 +1이 됩니다. 즉 (x, y)가 (i, j)와 동일한 의미를 갖는다고 생각하면 편합니다.

따라서 3행 2열 상하좌우 위치에 숫자 1이 몇 개 있는지는 다음과 같이 코드로 나타내 볼 수 있습니다.

x, y = 2, 1
dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

cnt = 0
for dir_num in range(4):
    nx, ny = x + dx[dir_num], y + dy[dir_num]
    if a[nx][ny] == 1:
        cnt += 1

print(cnt)
이처럼 각 방향에 대해 dx, dy의 쌍을 가져다가 쓰고 싶은 경우에 python에서는 zip이라는 함수를 자주 사용합니다. zip 함수는 넘긴 인자에 list나 tuple같이 순회가 가능한 변수를 여러 개 넘기면, 순서대로 첫 번째 원소부터 끝 원소까지 쌍으로 값을 뽑아주는 함수입니다.

arr1 = [1, 2, 3]
arr2 = [4, 5, 6]
for elem1, elem2 in zip(arr1, arr2):
    print(elem1, elem2)

>> 1 4
   2 5
   3 6
다른 언어에서는 배열 이름 자체를 dx, dy로 작성을 하지만, python에서는 zip함수와 함께 dxs, dys 이름으로 작성하는 것이 더 가독성이 좋습니다.

x, y = 2, 1
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

cnt = 0
for dx, dy in zip(dxs, dys):
    nx, ny = x + dx, y + dy
    if a[nx][ny] == 1:
        cnt += 1
그런데 만약, 3행 5열의 상하좌우 인접한 곳에 있는 1의 개수를 출력하는 코드를 작성하여 실행하면 어떤 일이 벌어질까요?

a = [[0, 0, 0, 1, 0],
     [0, 1, 1, 1, 0],
     [0, 0, 0, 0, 1],
     [1, 0, 1, 1, 1],
     [1, 0, 1, 1, 0]]

x, y = 2, 4
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]

cnt = 0
for dx, dy in zip(dxs, dys):
    nx, ny = x + dx, y + dy
    if a[nx][ny] == 1:
        cnt += 1

>>
     10 for dx, dy in zip(dxs, dys):
     11     nx, ny = x + dx, y + dy
---> 12     if a[nx][ny] == 1:
     13         cnt += 1
     14 

IndexError: list index out of range
Runtime Error가 발생하게 됩니다.

그 이유는 (2, 4) 위치에서 오른쪽 방향을 보게 되면 (nx, ny) 값이 (2, 5)가 되므로 Runtime Error가 발생하는 것입니다.
이 문제를 극복하기 위해서는 보통 인접한 위치가 격자 안에 들어오는 지를 판단하는 in_range 함수를 작성해줍니다.

in_range 함수의 모습은 다음과 같습니다. (x, y)가 격자 안에 들어오는 경우에만 True, 그렇지 않다면 False를 반환하는 함수 입니다.

def in_range(x, y):
    return 0 <= x and x < 5 and 0 <= y and y < 5
이제 인접한 곳에 1이 있는지를 확인하기 전에, 먼저 (nx, ny)가 격자 안에 들어오는지를 확인하면 Runtime Error를 방지할 수 있습니다.

a = [[0, 0, 0, 1, 0],
     [0, 1, 1, 1, 0],
     [0, 0, 0, 0, 1],
     [1, 0, 1, 1, 1],
     [1, 0, 1, 1, 0]]

x, y = 2, 4
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]


def in_range(x, y):
    return 0 <= x and x < 5 and 0 <= y and y < 5


cnt = 0
for dx, dy in zip(dxs, dys):
    nx, ny = x + dx, y + dy
    if in_range(nx, ny) and a[nx][ny] == 1:
        cnt += 1

print(cnt)

>> 1
따라서 격자에서 상하좌우를 확인하는 경우에는 꼭 in_range 함수를 이용해 격자 범위 안에 들어오는지를 확인하는 것이 필수입니다. 또, dx, dy 테크닉을 격자에서 사용하는 경우에는 수학에서의 x, y가 아닌 행, 열의 의미로 x, y를 사용함을 꼭 기억해야 합니다.

Side Note
위의 설명에서는 다음과 같이 조건을 걸어야 한다고 배웠습니다.

if in_range(nx, ny) and a[nx][ny] == 1:
만약 in_range 함수의 위치를 위와같이 if문의 뒤에 놓으면 결과가 어떻게 나올까요?

if a[nx][ny] == 1 and in_range(nx, ny):
전체 코드는 다음과 같습니다.

a = [[0, 0, 0, 1, 0],
     [0, 1, 1, 1, 0],
     [0, 0, 0, 0, 1],
     [1, 0, 1, 1, 1],
     [1, 0, 1, 1, 0]]

x, y = 2, 4
dxs, dys = [0, 1, 0, -1], [1, 0, -1, 0]


def in_range(x, y):
    return 0 <= x and x < 5 and 0 <= y and y < 5


cnt = 0
for dx, dy in zip(dxs, dys):
    nx, ny = x + dx, y + dy
    if a[nx][ny] == 1 and in_range(nx, ny):
        cnt += 1

print(cnt)

>>
     16 for dx, dy in zip(dxs, dys):
     17     nx, ny = x + dx, y + dy
---> 18     if a[nx][ny] == 1 and in_range(nx, ny):
     19         cnt += 1
     20 

IndexError: list index out of range
Runtime Error가 발생하게 됩니다. 그 이유는 (x, y)의 오른쪽이 (nx, ny)로 설정이 되면 그 값이 (2, 5)가 되기 때문에 a[nx][ny] == 1 코드에서 Runtime Error가 발생하게 되는 것입니다.
if 조건문의 경우에는 앞에서부터 순차적으로 조건을 확인하게 되기 때문에, in_range 함수의 결과하고는 상관없이 격자를 벗어나는 (nx, ny)에 대해 값이 1인지를 확인하게 되는 것입니다.

이와는 다르게 순서를 if in_range(nx, ny) and a[nx][ny] == 1: 같이 가져가게 되면, and 조건의 경우에 앞에 있는 조건이 False가 되면 and 정의상 뒤에 있는 조건을 봐야 할 필요가 없으므로 실행하지 않고 바로 빠져나가게 됩니다.

따라서 in_range와 같이 범위를 확인하는 조건의 경우에는 항상 if문 가장 앞에 작성하는 것이 정말 중요합니다.
