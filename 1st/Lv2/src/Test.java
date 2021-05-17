import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[][] m1 = new int[2][3];
        int[][] m2 = new int[2][3];
        int[][] m3 = new int[2][3];
        System.out.print("请输入第一个矩阵(矩阵为2行3列)的元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                m1[i][j] = input;
            }
        }
        System.out.print("请输入第二个矩阵(矩阵为2行3列)的元素：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                m2[i][j] = input;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }
        System.out.println("第一个矩阵为：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                //输出第一个矩阵
                System.out.print(m1[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println("第二个矩阵为：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                //输出第二个矩阵
                System.out.print(m2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("两个矩阵和为：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                //输出第三个矩阵
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }


    }
}


