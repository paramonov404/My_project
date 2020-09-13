package PR_1_Java;

import java.util.Random;
import java.util.Arrays;

public class PR_1_6 {

    public static void main(String[] args) {
    int mass[] = new int[8];

    for(int i=0;i<4;i++){
        mass[i]= (int) (Math.random()*10);
        System.out.print(mass[i]);
    }

    for(int i=4;i<8;i++){
            Random r = new Random();
            mass[i]= r.nextInt(11);
            System.out.print(mass[i]);
    }
        System.out.println();
    Arrays.sort(mass);
        for(int i=0;i<8;i++){
            System.out.print(mass[i]);
        }
    }

}
