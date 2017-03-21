package algo_tools.intro;

import java.util.Scanner;

public class APlusB {
  public static void main(String[] args) {
    try(Scanner s = new Scanner(System.in)){
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(a + b);
    } catch(Exception e) {
        e.getMessage();
    }

  }
}