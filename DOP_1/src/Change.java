public class Change {
    public int search(int x, int y) {
        if (x == 0)
            return 1;
        if (x < 0)
            return 0;
        if (y == 5)
            return search(x - 5, 5) + search(x - 3, 3) + search(x - 1, 1);
        if (y == 3)
            return search(x - 3, 3) + search(x - 1, 1);
        if (y == 1)
            return search(x - 1, 1);
        return 0;
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.search(4, 5));
    }
}
