package org.example;

public class Matrix {

    public static void main(String[] args) {

        int[][] arr = { {1,2,3},
                        {4,5,6}};


        System.out.println("Исходная матрица:");
        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }


        System.out.println("Результат:");

        int[][] arr2 = new int[3][2];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 2; j++) {

                arr2[i][j] = arr[j][i];
                System.out.print(arr2[i][j]+" ");

            }

            System.out.println();
        }


    }

}


