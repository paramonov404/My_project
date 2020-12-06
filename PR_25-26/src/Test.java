public class Test {
    public static void main(String[] args) {
        MyHashMap<Integer,String> passportsAndNames = new MyHashMap<>();

        passportsAndNames.add(22800000, "Парамонов Олег Андреевич");
        passportsAndNames.add(14880000, "Иванов Иван Иванович");
        passportsAndNames.add(12345678, "qwerty zxc xXx");
        passportsAndNames.add(14880000, "Зубенко Михаил Петрович");

        System.out.println(passportsAndNames.get(22800000));
        System.out.println(passportsAndNames.get(14880000));
        System.out.println(passportsAndNames.get(12345678));
        passportsAndNames.remove(14880000);
        System.out.println(passportsAndNames.get(14880000));

        for(String Name : passportsAndNames) {
            System.out.println(Name);
        }

    }
}
