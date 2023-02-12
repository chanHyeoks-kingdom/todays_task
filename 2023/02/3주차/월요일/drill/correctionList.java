public class Main {
    public static void main(String[] args) {
        List list = new ArrayList(10);
        list.add(1);
        list.add(5);
        list.add(4);
        list.add(11);
        list.add(10); // ArrayList에 값 한개씩 입력
        System.out.println(list); // [1,5,4,11,10]

        Collections.sort(list); // list 정렬
        System.out.println(list); // [1,4,5,10,11]

        System.out.println(list.size()); // arrayList의 크기 출력

        arrayList.remove(4); // 인덱스를 활용하여 해당하는 값 제거
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // get을 이용하여 값 1개씩 출력
        }
				for (int current : list) {
						System.out.println(current);
        }

    }
}
