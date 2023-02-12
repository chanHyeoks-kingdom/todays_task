public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(); // ArrayDeque를 이용한 선언(제네릭스 이용)
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4); // arrayDeque의 앞에 값을 삽입
        System.out.println(arrayDeque);

        arrayDeque.addLast(0); // arrayDeque의 끝에 값을 삽입
        System.out.println(arrayDeque);

        arrayDeque.offerFirst(10); // addFirst와 비슷하지만 큐의 크기 문제가 생길 때, offerFirst는 false를,
        // addFrist는 exception을 반환합니다.
        System.out.println(arrayDeque);

        arrayDeque.offerLast(-1); // arrayDeque의 끝에 값을 삽입
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.size()); // 7


        System.out.println(arrayDeque.removeFirst()); // 첫번째 값을 제거하면서 그 값을 리턴
        System.out.println(arrayDeque.removeLast()); // 마지막 값을 제거하면서 그 값을 리턴
		    System.out.println(arrayDeque);
				System.out.println(arrayDeque.size()); // 5

        System.out.println(arrayDeque.pollFirst()); // 첫번째 값을 반환 및 제거하면서 그 값을 리턴
        System.out.println(arrayDeque);
				System.out.println(arrayDeque.size()); // 4

        System.out.println(arrayDeque.pollLast()); // 마지막 값을 반환 및 제거하면서 그 값을 리턴
        System.out.println(arrayDeque);
				System.out.println(arrayDeque.size()); // 3

        System.out.println(arrayDeque.peekFirst()); // 첫번째 값을 반환, 제거하지 않음
        System.out.println(arrayDeque.peekLast()); // 마지막 값을 반환, 제거하지 않음
				System.out.println(arrayDeque.size()); // 3
    }
}
