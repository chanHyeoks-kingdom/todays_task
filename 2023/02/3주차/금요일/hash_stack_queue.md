
### 바쁘다는 핑계로 해쉬, 스택, 큐 구현 복습을 진행하지 않았다. 지금 즉석에서 해보려한다.


##### HASH 구현

```
# 체이닝 방식을 이용할건데 이를 위해 링크드 튜플 클래스 정의
class LinkedTuple:
  def __init__(self):
    self.items = []
   
  def add(self, key, value):
    self.items.append((key, value))
  def get(self, key):
    for k, v in items:
        if k == key:
          return value

  # 해쉬 테이블 클래스를 구현
class HashTable:
  def __init__(self):
    self.items =[]
    for _ in range(8):
      self.items.append(LinkedTuple())
  
  def add(self, key, value):
    index = hash(key) % len(self.items)
    self.items[index].add(value)
  
  def get(self, key):
    index = hash(key) % len(self.items)
    self.items[index].get(key)
```





