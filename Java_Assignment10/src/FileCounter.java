import java.util.Scanner;

public class FileCounter
{
	private int wordCount;
	private int characterCount;
	private int lineCount;

	public FileCounter()
	{
		wordCount = 0;
		characterCount = 0;
		lineCount = 0;
	}

	public void read(Scanner in)
	{
		while(in.hasNext()){
			String line = in.nextLine();
			lineCount++; //counts each line
			characterCount +=line.length(); //finds the length of the line which gives the number of characters
			String[] words = line.split(" ");
			for(String word: words){
				wordCount++;  //finds the number of words-line by line
			}
		}
	}

	public int getWordCount()
	{
		return wordCount;

	}

	public int getLineCount()
	{
		return lineCount;

	}

	public int getCharacterCount()
	{
		return characterCount;

	}

}
