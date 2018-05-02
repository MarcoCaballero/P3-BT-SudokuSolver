import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
	private static final int CARRIAGE_RETURN = 13;
	private static final int LINE_FEED = 10;
	private static final int BLANK_SPACE = 32;

	private InputStream input;
	private BufferedReader br;

	public int[][] fillFromFile(String fileName, int size) throws IOException {
		input = getClass().getClassLoader().getResourceAsStream(fileName);
		br = new BufferedReader(new InputStreamReader(input));
		System.out.println("Received file to compress: ");
		System.out.println("File name: '" + fileName + "' \n");
		int c;
		int i = 0;
		int j = 0;
		int[][] filled = new int[size][size];
		while ((c = br.read()) != -1) {
			switch (c) {
			case BLANK_SPACE:
				j++;
				break;
			case CARRIAGE_RETURN:
				i++;
				j = 0;
				break;
			case LINE_FEED:
				break;
			default:
				filled[i][j] = c - 48;
				break;
			}
		}

		return filled;
	}
}
