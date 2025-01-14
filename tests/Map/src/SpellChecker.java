/*
 * SpellChecker
 *
 * Version 1.0
 *
 * 2015-07-10
 *  
 * (c) Michael Nahas
 *
 * CTY 2015 DATA LAN
 * 
 * Uses a SimpleMap to spell check a file
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class SpellChecker {
	public static final String WORDS_FILE = "/usr/share/dict/words"; // on Macs
	public static final String FILE_TO_CHECK = "src/Alice.txt";
	static SimpleHashMap map = new SimpleHashMap();
	//
	// Something
	//

	public static void main(String[] args) {
		SpellChecker sc = new SpellChecker(WORDS_FILE);

		try {
			BufferedReader br = new BufferedReader(
					new FileReader(FILE_TO_CHECK));
			for (String line = br.readLine(); line != null; line = br
					.readLine()) {
				String[] words = line.split("\\s+");
				for(String s : words){
					if(hasWord(s) == false){
						System.out.println(s);
					}
				}
				

			}
		} catch (FileNotFoundException e) {
			System.err.println("Could not find file: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

	public SpellChecker(String filename) {
	
		

		try {
			BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
			for (String line = br.readLine(); line != null; line = br
					.readLine()) {
				map.put(line, null);
				//
				// Something
				//

			}
		} catch (FileNotFoundException e) {
			System.err.println("Could not find file: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("IOException: " + e.getMessage());
		}
	}

	public static boolean hasWord(String s) {
		boolean isWord = false;
		isWord = map.containsKey(s.toLowerCase());
		return isWord;
	}
}
