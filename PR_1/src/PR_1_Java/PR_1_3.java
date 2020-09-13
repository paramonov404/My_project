package PR_1_Java;

public class PR_1_3 {
    public static void main(String[] args) {
        int [] mass = new int[] {1,2,3,4,5,6,7,8,9};
        int sum_1 = 0, sum_2 = 0, sum_3 = 0;

        for (int i=0;i<mass.length;i++){
            sum_1 += mass[i];
        }
        System.out.println(sum_1);

        int count = 0;
        while (count < mass.length){
            sum_2+=mass[count];
            count += 1;
        }
        System.out.println(sum_2);

        count = 0;
        do{
            sum_3 += mass[count];
            count += 1;

        } while (count < mass.length);
        System.out.println(sum_3);
    }
}

