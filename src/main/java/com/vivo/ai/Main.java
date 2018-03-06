package com.vivo.ai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    try {
      InputStream in = new FileInputStream("demo/data/model.bin");
    } catch (FileNotFoundException e) {
      System.out.println(System.getProperty("user.dir"));
      e.printStackTrace();
    }

    int[] indices = new int[6397];
    float[] values = new float[6397];
    try {
      Scanner in = new Scanner(Paths.get("demo/data/test.txt"), "UTF-8");
      String[] line = in.nextLine().split(" ");
      double label = Double.parseDouble(line[0]);
      for (int i = 1; i < line.length; i++) {
        String[] pair = line[i].split(":");
        indices[i - 1] = Integer.parseInt(pair[0]);
        values[i - 1] = Float.parseFloat(pair[1]);
      }
    } catch (IOException e) {
      System.out.println(Paths.get("demo/data/test.txt"));
      e.printStackTrace();
    }

    System.out.println(indices.length);
    System.out.println(values.length);
  }
}