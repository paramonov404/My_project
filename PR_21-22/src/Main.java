import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static int id,idTemp,state;
    static String data, description;
    static boolean isGood;

    public static void main(String[] args) {
        JsonLocal local = new JsonLocal();
       JsonServer server = new JsonServer();

        System.out.println("\n 1 - локально \n 2 - через сервер");
        switch (scanner.nextInt()) {
            case 1 -> run(local);
            case 2 -> run(server);
            default -> System.out.println("Попробуйте ещё раз");
        }
    }

    public static void run(ItemsStore itemsStore){
        do {
            System.out.println("1-получение, 2-добавление, 3-редактирование, 4-удаление, 5-получить все, 6-закончить");
            state=scanner.nextInt();
            switch (state){

                case 1:
                    System.out.print("Введите id: ");
                    int getId = scanner.nextInt();
                    Item respond = itemsStore.get(getId);
                    if (respond==null) {
                        System.out.println("Item не найден");
                    } else {
                        System.out.println(respond);
                    }
                    break;
                case 2:
                    System.out.print("Item id: ");
                    id = scanner.nextInt();
                    System.out.print("Item data: ");
                    data = scanner.next();
                    System.out.print("Is this item good: ");
                    isGood = scanner.nextBoolean();
                    System.out.print("Item description: ");
                    description = scanner.next();
                    System.out.println("Добавлен: "+itemsStore.addItem(new Item(id, data, isGood, description)));
                    break;
                case 3:
                    System.out.print("Редактируемый Item id: ");
                    idTemp = scanner.nextInt();
                    System.out.print("Item id: ");
                    id = scanner.nextInt();
                    System.out.print("Item data: ");
                    data = scanner.next();
                    System.out.print("Is this item good: ");
                    isGood = scanner.nextBoolean();
                    System.out.print("Item description: ");
                    description = scanner.next();
                    itemsStore.editItem(idTemp,new Item(id, data, isGood, description));
                    break;
                case 4:
                    System.out.print("Item id: ");
                    id = scanner.nextInt();
                    itemsStore.deleteItem(id);
                    break;
                case 5:
                    List<Item> items = itemsStore.getAll();
                    for (Item i: items) {
                        System.out.println(i);
                    }
                    break;
                default:
                    break;
            }
        }while (state!=6);
    }
}