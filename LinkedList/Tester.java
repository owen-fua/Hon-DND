public class Tester {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, 4};
        SinglyLinkedList list = new SinglyLinkedList<Integer>(values);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        Integer test = 1;
        list.remove(test);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println(" ");
        System.out.println(list.toString());

        Integer test2 = 7;
        list.add(1, test2);
        
        System.out.println(" ");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println(list.toString());

        System.out.println(" ");
        System.out.println("Testing, get head, tail, is empty, size");
        System.out.println(list.getHead());
        System.out.println(list.getTail());
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(" ");
        System.out.println("list");

    };
}
