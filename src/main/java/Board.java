import java.util.Arrays;

public class Board {

	private int[][] items;

	public Board(int m, int n) {
		items = new int[m][n];
	}

	public void fill(int[][] entrySet) {
		items = entrySet;
	}
	
	public int[][] getItems() {
		return items;
	}
	
	public void setValue(int row, int col, int value) {
		items[row][col] = value;
	}
	
	public int getValue(int row, int col) {
		return items[row][col];
	}

	@Override
	public String toString() {
		StringBuilder bs = new StringBuilder();
		for (int[] is : items) {
			bs.append(Arrays.toString(is));
			bs.append("\n");
		}
		bs.append("\n");
		return bs.toString();
	}

}
