package PR_1_Java;

public class PR_1_7 {

    public static void main(String[] args) {
        fact(4);
    }
    public static void fact(int x){
        long sum = 1;
        for (int i=1;i<=x;i++){
            sum *= i;
        }
        System.out.println(sum);
    }
}
