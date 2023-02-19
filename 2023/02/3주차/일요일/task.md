


##### (1) [dx-dy, 행렬곱 관련 알고리즘 문제 원리 확실히 정리해서 블로그 업로드](https://blog.naver.com/cksgurwkd12/223020410988) DONE
##### (2) 영어 문장 복습하기
   - i'm sick of ~ (~~가 지겨워) <br>
   - sick (쩐다) <br>
   - i'm craving ~ (~가 땡겨) <br>
##### (3) 자료구조 구현 복습 (스택, 큐, 해쉬)
##### (4) [dx-dy와 행렬의 순회 문제 정리](https://blog.naver.com/cksgurwkd12/223020977532)

```
# stack 구현

class Node:
   def __init__(self, value):
      self.value = value
      self.next = None

class Stack:
   def __init__(self):
      self.head = None
   
   def push(self, value):
      new_node = Node(value)
      new_node.next = self.head
      self.head = new_node
      
   def pop(self):
      if is_empty():
         return "this stack is empty"
      delete_node = self.head.value
      self.head = self.head.next
      return delete_node
      
   def peek(self):
      return self.head.value
      
   def is_empty(self):
      return self.head
   
```
