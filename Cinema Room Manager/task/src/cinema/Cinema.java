package cinema;

import java.util.Scanner;

public class Cinema {

    static int purchasedTicket = 0;

    static int currentIncome = 0;

    static Scanner scanner = new Scanner(System.in);
    static char[][] cinema;

    public static void main(String[] args) {


        // parameters
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        // initializing array
        cinema = new char[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }

        print();

        // menu loop
        while (true) {
            int choice = menu();

            switch (choice) {
                case 1:
                    print();
                    break;
                case 2:
                    int[] userSelect = userSelect();
                    updateMatrix(rows, seats, userSelect);
                    print();
                    ticketPrice(rows, seats, userSelect[0]);
                    break;
                case 3:
                    printStatistics();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong input");
            }
        }
    }

    public static void print() {

        System.out.println();
        System.out.println("Cinema: ");
        System.out.print("  ");

        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int menu() {
        System.out.println();
        System.out.println("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit""");

        int choice;

        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }

        return choice;
    }

    public static void updateMatrix(int rows, int seats,int[] userSelect) {

        int row = userSelect[0];
        int seat = userSelect[1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                if (cinema[i][j] == cinema[row - 1][seat - 1]) {
                    cinema[row - 1][seat - 1] = 'B';
                } else {
                    cinema[i][j] = 'S';
                }
            }
        }
    }

    public static int[] userSelect() {

        int[] userSelect = new int[2];

        while (true) {
            try {
                System.out.println();
                System.out.println("Enter a row number: ");
                int row = scanner.nextInt();

                System.out.println("Enter a seat number in that row: ");
                int seat = scanner.nextInt();

                // check selection validity
                if (row >= 1 && row <= cinema.length && seat >= 1 && seat <= cinema[0].length) {
                    // check selection availability
                    if (cinema[row - 1][seat - 1] == 'S') {
                        userSelect[0] = row;
                        userSelect[1] = seat;
                        purchasedTicket++;
                        break;
                    } else {
                        System.out.println();
                        System.out.println("That ticket has already been purchased!");
                    }
                } else {
                    System.out.println("Wrong input");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Wrong input");
                scanner.nextLine();
            }
        }

        return userSelect;
    }

    public static void ticketPrice(int rows, int seats, int row) {

        int front = rows / 2;

        if (rows * seats <= 60 || row <= front) {
            System.out.println("Ticket price: $10");
            currentIncome += 10;
        } else {
            System.out.println("Ticket price: $8");
            currentIncome += 8;
        }
    }

    public static void printStatistics() {

        int rows = cinema.length;
        int seats = cinema[0].length;
        int totalSeats = rows * seats;
        double percentage = (double) purchasedTicket / totalSeats * 100;


        int front = rows / 2;
        int back = rows - front;

        if (rows / 2 == 0) {
             back = rows / 2;
        } else {
             back = rows / 2 + 1;
        }

        int totalIncome;
        if (rows * seats <= 60) {
            totalIncome = totalSeats * 10;
        } else {
            totalIncome = (front * seats * 10) + (back * seats * 8);
        }

        System.out.println("""
                Number of purchased tickets: %d
                Percentage: %.2f%%
                Current income: $%d
                Total income: $%d
                """.formatted(purchasedTicket, percentage, currentIncome, totalIncome));
    }

}