import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // import scanner class
        Scanner scanner = new Scanner(System.in);

        // read length of the array
        int n = scanner.nextInt();

        // input the array elements
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // compare elements
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            int product = arr[i] * arr[i + 1];
            if (product > max) {
                max = product;
            }
        }
        System.out.println(max);
    }
}