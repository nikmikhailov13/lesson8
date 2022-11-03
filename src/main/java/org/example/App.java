package org.example;

import java.util.Arrays;
import java.util.Random;
import org.example.Computer.OperatingSystem;

/**
 * Hello world!
 */
public class App {

  private static int M = 3;
  private static int N = 3;

  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.printf("%3d", matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static int[][] generateMatrix() {
    int[][] matrix = new int[M][N];
    Random random = new Random();
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] = random.nextInt(0, 10);
      }
    }
    return matrix;
  }

  public static void transpose(int[][] matrix) {

    for(int i = 0; i < M; i++) {
      for(int j = i + 1; j < N; j++){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }



  }

  public static void main(String[] args) {

    int[][] matrix = generateMatrix();
    printMatrix(matrix);
    transpose(matrix);
    System.out.println("-------------------------");
    printMatrix(matrix);

  }

}

