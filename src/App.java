public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Integer[] a = { 123, 32, 54, 35, 76, 19, 54, 54, 54, 54 };
        List<Integer> integerList = new List<Integer>(a);
        Integer x = 5;
        Integer integer2 = 69;

        integerList.display();
        integerList.insert(Integer.class, 0, x);
        integerList.insert(Integer.class, integer2);
        integerList.display();
        integerList.replace(1, 444444);
        integerList.display();
        integerList.RemoveAll(54, "==");
        integerList.display();
        // System.out.println(integerList.get(0));

        // List <Integer> result = integerList.FindAll(35, "!=");
        // result.display();

        String[] b = { "foo", "bar", "foo", "string", "hello" };
        List<String> stringList = new List<String>(b);

        stringList.display();
        stringList.insert(String.class, 0, "inserted string");
        stringList.insert(String.class, "another insert");
        stringList.replace(0, "edited insert");
        stringList.display();

        List<Integer> answer = stringList.FindAll("foo", "!=");
        answer.display();
    }
}
