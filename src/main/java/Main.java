public class Main {

	public static void main(String[] args) throws Exception {

		final int BOARD_SIZE = 9;

		Board board = new Board(BOARD_SIZE, BOARD_SIZE);
//		board.fill(new FileReader().fillFromFile("sudokuEntrySet", 9));
//		board.fill(new FileReader().fillFromFile("sudokuEntrySet_WRONG", 9)); // Fill with imposible sudoku.
		board.fill(new FileReader().fillFromFile("evilEntrySet", 9)); // Fill with imposible sudoku.

		BTSudokuSolver solver = new BTSudokuSolver(board);
		boolean result = solver.solve();
		
		System.out.println("BTSudoku solves the problem ?, " + result + "\n");

		System.out.print(board);
	}

}
