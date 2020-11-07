import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JTextArea;

public class ReadFromFile extends Base {
	
	public ReadFromFile(String path) {
		super(path);
	}
	public void readFromFile(JTextArea readTextArea) {
		try {
			Path path = Paths.get(this.getPath());
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		    
		    for(String line: lines) {
		    	readTextArea.append(line + "\n");
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
