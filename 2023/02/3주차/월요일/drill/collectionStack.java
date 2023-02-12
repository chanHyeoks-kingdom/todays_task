public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println(stack); // Stack을 출력합니다

        System.out.println(stack.peek()); // Stack의 가장 상단 값을 출력합니다.(삭제는 하지 않습니다.)
        stack.pop(); // Stack의 가장 상단 값을 제거합니다.
        System.out.println(stack);
        System.out.println(stack.size()); // Stack의 크기를 반환합니다.
        System.out.println(stack.contains(1)); // Stack에 1이라는 값이 있으면 true를, 그렇지 않으면 false를 반환합니다.
        System.out.println(stack.empty()); // STack이 비어있으면 true를, 그렇지 않으면 false를 반환합니다.
        System.out.println(stack);
    }
}
