public class Tester {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4};
        SinglyLinkedList list = new SinglyLinkedList<Integer>(values);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.getHead().getValue());
        list.set(0, 9);
        System.out.println(list.get(0));
    };
}
