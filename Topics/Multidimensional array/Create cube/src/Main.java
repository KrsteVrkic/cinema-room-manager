import java.util.Arrays;
class ArrayOperations {

    public static int[][][] createCube() {
        // write your code here
        int[][][] cube = new int[3][3][3];

        int counter = 0;

        for (int i = 0; i < 3; i++) {
             for (int j = 0; j < 3; j++) {
                 for (int k = 0; k < 3; k++) {
                     cube[i][j][k] = counter;
                     counter++;
                 }
             }
             counter = 0;
        }
        return cube;
    }

    public static void main(String[] args) {
        int[][][] cubeA = createCube();
        System.out.println(Arrays.deepToString(cubeA));
    }



}