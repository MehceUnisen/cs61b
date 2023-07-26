package Project1A;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> x = new ArrayDeque<>();
        for (int i = 0; i < 1000; i++) {
            x.addLast(i);
        }
        for (int i = 0; i < 900; i++) {
            x.removeLast();
        }

    }

}
