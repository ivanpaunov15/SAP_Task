import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile extends Base{
	
	public WriteToFile(String path) {
		super(path);
	}
	public void writeToFile(String word) {
		try {
			File file = new File(this.getPath());
			FileWriter fr = new FileWriter(file, true);
			fr.write(word + " ");
			fr.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	public void newLine() {
		try {
			File file = new File(this.getPath());
			FileWriter fr = new FileWriter(file, true);
			fr.write("\n");
			fr.close();
		      System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
