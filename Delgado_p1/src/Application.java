
import java.util.*;
import java.io.*;
import java.awt.*;

public class Application {
	public static void main(String[] args) {
    run();
	}

  public static void run(){
    Scanner kb = new Scanner(System.in);
    System.out.print("\n\t1: Encrypt\n\t2: Decrypt\n\t3: Exit\n\nChoose mode: ");
    int op = kb.nextInt();
    String input;

    //This works to clean the input stream.
    kb.nextLine();

    if(op == 1){
      Encrypter myE = new Encrypter();
      System.out.println("\nEncryption mode");
      System.out.print("\nEnter value to encrypt: ");
      input = kb.nextLine();
      String encrypted = myE.encrypt(input);
      System.out.println("Encrypted Value is: "+encrypted);
    }
    else if(op == 2){
      Decrypter myD = new Decrypter();
      System.out.println("\nDecryption mode");
      System.out.print("\nEnter value to decrypt: ");
      input = kb.nextLine();
      String decrypted = myD.decrypt(input);
      System.out.println("Decrypted Value is: "+decrypted);
    }
    else{
      return;
    }

    run();
  }

}
