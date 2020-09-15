
import java.util.*;
import java.io.*;
import java.awt.*;

public class Application {
	public static void main(String[] args) {
    String input = "";
    while(!input.equals("9999")){
      Scanner kb = new Scanner(System.in);
      input = kb.nextLine();
  		Encrypter myEncrypter = new Encrypter();
      Decrypter myDecrypter = new Decrypter();
      String str = myEncrypter.encrypt(input);
      str = myDecrypter.decrypt(str);
      System.out.println(str);
    }
	}
}
