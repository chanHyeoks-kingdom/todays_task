



```
import sys


developers_level = list(map(int, input().split()))

answer = sys.maxsize
n = len(developers_level)
for i in range(n):
    for j in range(n):
        left_sum = sum(developers_level[i:j])
        right_sum = sum(developers_level)-left_sum
        difference_each_group = abs(left_sum-right_sum)

        answer = min(answer, difference_each_group)

print(answer)

```
