
import java.util.*;
import java.io.*;
import java.awt.*;

public class Decrypter {
	public static void main(String[] args) {
		//System.out.println(decrypt("0179"));
	}

	public static String decrypt(String input){
    int a[] = new int[4];
    for(int i = 0; i < 4; i++){
      a[i] = CtoI(input.charAt(i));
			if(a[i] < 7){
				a[i] = a[i] + 10;
			}
      a[i] = a[i]-7;
    }

		//Swaps first digit with third and second with fourth
    int temp = a[0];
    a[0] = a[2];
    a[2] = temp;
    temp = a[1];
    a[1] = a[3];
    a[3] = temp;

    return arrToS(a);
  }

	//Converts Char to the intended int
	public static int CtoI(char a){
    int b = a - '0';
    return b;
  }

	//Converts the array into a String
  public static String arrToS(int[] number){
    String output = "";
    for(int i = 0; i < 4; i++){
      char a = (char)(number[i]+'0') ;
      output = output + a;
    }
    return output;
  }
}
