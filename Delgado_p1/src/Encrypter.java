
import java.util.*;
import java.io.*;
import java.awt.*;

public class Encrypter {

	public static void main(String[] args) {

	}


  public static String encrypt(String input){
    int a[] = new int[4];
    for(int i = 0; i < 4; i++){
      a[i] = CtoI(input.charAt(i)) + 7;
      a[i] = a[i]%10;
    }

    int temp = a[0];
    a[0] = a[2];
    a[2] = temp;
    temp = a[1];
    a[1] = a[3];
    a[3] = temp;

    return arrToS(a);
  }


  public static int CtoI(char a){
    int b = a - '0';
    return b;
  }


  public static String arrToS(int[] number){
    String output = "";
    for(int i = 0; i < 4; i++){
      char a = (char)(number[i]+'0') ;
      output = output + a;
    }
    return output;
  }
}
