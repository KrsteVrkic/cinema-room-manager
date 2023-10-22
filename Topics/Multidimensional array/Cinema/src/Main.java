import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        // first we take the input n rows and m seats
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();

        // create a 2D array with n rows and m seats
        int[][] cinema = new int[rows][seats];

        // then populate the array with n lines each containing m numbers (0 or 1)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }

        // last number is read now to find k seats
        int k = scanner.nextInt();

        // is it possible to buy k tickets to neighbouring seats in the same row?
        boolean rowFound = false;
        int consecutive = 0;
        int rowCount = 0;

        // loop over all rows
        for (int i = 0; i < rows && !rowFound; i++) {
            int emptySeatCount = 0;
            // loop over seats
            for (int j = 0; j < seats; j++) {
                if (cinema[i][j] == 0) {
                    emptySeatCount++;
                    if (emptySeatCount == k) {
                        rowFound = true;
                        rowCount = i + 1;
                        break;
                    }
                } else if (cinema[i][j] != 0){
                    emptySeatCount = 0;
                }
            }
        }

        if (rowFound) {
            System.out.println(rowCount);
        } else {
            System.out.println("0");
        }
    }
}

