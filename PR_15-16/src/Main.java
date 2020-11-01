import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList <Main> Nodes = new ArrayList<>(5);
    String name;
    ArrayList <Object[]> Commands = new ArrayList<>();

    public Main(String name) {
        this.name = name;
    }

    public void setCommand(Object[] command) {
        this.Commands.add(command);
    }

    public static void main(String[] args) {

    Main S1 = new Main("S1");
    S1.setCommand(S1.createCommand("create_project",0,2));
    S1.setCommand(S1.createCommand("add_library",1,5));
    Nodes.add(S1);

    Main S2 = new Main("S2");
    S2.setCommand(S2.createCommand("test",0,3));
    S2.setCommand(S2.createCommand("drop_db",1,4));
    Nodes.add(S2);

    Main S3 = new Main("S3");
    S3.setCommand(S3.createCommand("drop_db",0,4));
    S3.setCommand(S3.createCommand("add_library",1,5));
    Nodes.add(S3);

    Main S4 = new Main("S4");
    S4.setCommand(S4.createCommand("restart",0,3));
    S4.setCommand(S4.createCommand("deploy",1,5));
    Nodes.add(S4);

    Main S5 = new Main("S5");
    S5.setCommand(S5.createCommand("deploy",0,1));
    S5.setCommand(S5.createCommand("restart",1,3));
    Nodes.add(S5);

    S1.makeCommand();
    }

    public Object[] createCommand(String commandName,int rule,int index){
    Object[] command = new Object[3];
    command[0] = commandName;
    command[1] = rule;
    command[2] = index;
    return command;
    }

    public void makeCommand(){
        Scanner scan = new Scanner(System.in);
        int rule = scan.nextInt();
        if (rule == 0 || rule == 1){
            System.out.println((String) this.Commands.get(rule)[0]);
            Nodes.get((Integer) this.Commands.get(rule)[2]-1).makeCommand();
        }
    }
}