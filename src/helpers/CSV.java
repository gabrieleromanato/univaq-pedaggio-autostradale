package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CSV {

	public CSV() {
		
	}
	
	public static HashMap<String, String> read(File f, String[] keys) {
		HashMap<String, String> output = new HashMap<>();
		
		if(f != null) {
			StringBuilder fileContents = new StringBuilder((int)f.length());
			try {
				Scanner scanner = new Scanner(f);
				while(scanner.hasNextLine()) {
		            fileContents.append(scanner.nextLine());
		        }
				scanner.close();
				String data = fileContents.toString();
				String[] parts = data.split(",");
				
				if(parts.length == keys.length) {
					for(int i = 0; i < keys.length; i++) {
						output.put(keys[i], parts[i]);
					}
				}
			} catch(FileNotFoundException e) {
				
			}
		}
		
		return output;
	}

}
