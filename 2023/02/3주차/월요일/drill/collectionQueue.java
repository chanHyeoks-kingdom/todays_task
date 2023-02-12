public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(3);
        queue.add(5);//Queue에 값 삽입합니다.
        System.out.println(queue);//Queue 출력합니다.
        System.out.println(queue.poll()); // Queue에서 객체를 꺼내서 반환합니다.
        queue.add(7);
        queue.add(11);
        queue.add(9);
        System.out.println(queue);
        System.out.println(queue.peek()); //Queue에서 삭제 없이 요소를 반환합니다.
        System.out.println(queue);
    }
}
