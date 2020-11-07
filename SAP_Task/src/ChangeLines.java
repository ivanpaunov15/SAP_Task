import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.List;

public class ChangeLines extends Base{
	
	public ChangeLines(String path) {
		super(path);
	}
	public void changeWholeLine(int firstLine, int secondLine) {
		try {
			Path path = Paths.get(this.getPath());
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		    String firstLineText = lines.get(firstLine-1);
		    String secondLineText = lines.get(secondLine-1);
		    lines.set(firstLine - 1, secondLineText);
		    lines.set(secondLine-1, firstLineText);
	    
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println("Lines changed");
		} catch (IOException e) {
			e.printStackTrace();
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Index is out of range");
			e.printStackTrace();
		}
	}
	public void changeWordsByIndex(int firstLine,int firstWord,int secondLine,int secondWord) {
		try {
			Path path = Paths.get(this.getPath());
		    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			String firstLineText = lines.get(firstLine-1);
		    String secondLineText = lines.get(secondLine-1);
		    String[] firstLineArray = firstLineText.split("\\s+");
		    String[] secondLineArray = secondLineText.split("\\s+");
		    
		    
		    String temp = firstLineArray[firstWord-1];
		    firstLineArray[firstWord-1] = secondLineArray[secondWord-1];
		    secondLineArray[secondWord-1] = temp;
		    
		    firstLineText = convertStringArrayToString(firstLineArray," ");
		    secondLineText = convertStringArrayToString(secondLineArray," ");
		    
		    lines.set(firstLine - 1, firstLineText);
		    lines.set(secondLine-1, secondLineText);
	    
			Files.write(path, lines, StandardCharsets.UTF_8);
			System.out.println("Lines changed");
		} catch (IOException e) {
			e.printStackTrace();
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Index is out of range");
			e.printStackTrace();
		}
	}
	private static String convertStringArrayToString(String[] strArr, String delimiter) {
		StringBuilder sb = new StringBuilder();
		for (String str : strArr)
			sb.append(str).append(delimiter);
		return sb.substring(0, sb.length() - 1);
	}
}