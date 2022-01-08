import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num = setEndNum();
        findPrims(num);

    }
    private static int setEndNum() {
        System.out.print("Введите конечное число для поиска: ");
        Scanner in = new Scanner(System.in);
        int lastNum = in.nextInt();
        return lastNum;
    }

    private static void findPrims(int num) {
        boolean[] primes = new boolean[num + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        BitSet bitSet = new BitSet();
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i])
                for (int j = 2; i * j < primes.length; ++j)
                    primes[i * j] = false;
            bitSet.set(i);
        }

        System.out.print("Простые числа до " + num + ": ");
        for (int i = 0; i < primes.length; i++)
            if (primes[i]) {
                bitSet.set(i);
                System.out.print(i + " ");
            }
    }
}