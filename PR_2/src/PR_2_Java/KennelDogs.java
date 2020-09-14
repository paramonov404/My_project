package PR_2_Java;

public class KennelDogs {
 private Dog mass[] = new Dog[10];

public void addDog(Dog ... args){
    for (int i=0;i < args.length;i++){
        mass[i] = args[i];
        System.out.println(args[i].toString());
    }
}

    public static void main(String[] args) {
KennelDogs kennel = new KennelDogs();
Dog dog_1 = new Dog("Vasya",5);
Dog dog_2 = new Dog("Petya",4);
Dog dog_3 = new Dog("Vova",7);

kennel.addDog(dog_1,dog_2,dog_3);

    }
}
