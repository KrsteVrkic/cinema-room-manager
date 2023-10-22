import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Read the length of the array
        int n = scanner.nextInt();

        // Input: Read the array elements
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if the array is sorted in ascending order
        boolean isAscending = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                isAscending = false;
                break;
            }
        }

        // Output: Display the result
        if (isAscending) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        scanner.close();
    }
}