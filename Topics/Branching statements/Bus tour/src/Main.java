import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int busHeight = scanner.nextInt();
        int bridges = scanner.nextInt();
        int bridgeNumber = 1;
        boolean busCrash = false;

        // loop to check input bridge height
        for (int i = bridgeNumber; i <= bridges; i++) {
            int bridgeHeight = scanner.nextInt();
            if (busHeight >= bridgeHeight) {
                System.out.println("Will crash on bridge " + bridgeNumber);
                busCrash = true;
                break;
            } else if (busHeight < bridgeHeight) {
                bridgeNumber++;
            }
        }

        if (!busCrash) {
            System.out.println("Will not crash");
        }
    }
}