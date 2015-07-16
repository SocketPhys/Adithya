import java.io.*;
import java.util.Scanner;


public class error {

	public static void main(String[] args) {
		try{
			System.out.println("before");
            main(null);
            System.out.println("ASDF");
        }
        catch(StackOverflowError e){
            e.getStackTrace();
            System.out.println("ASD");
        }

	}

}
