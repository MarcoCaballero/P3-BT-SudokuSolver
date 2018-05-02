public class BTSudokuSolver {
	private static final int BOARD_SIZE = 9;
	private static final int FILL_SIZE = 10;
	private static final int QUAD_SIZE = 3;

	private Board board;

	public BTSudokuSolver(Board board) {
		this.board = board;
	}

	public boolean solve() throws Exception {
		return backTrackingAlgorithm(0, 0);
	}

	private boolean backTrackingAlgorithm(int row, int col) throws Exception {

		if (row == 9) {
			return true;
		}

		if (board.getValue(row, col) != 0) {
			if (backTrackingAlgorithm((col == 8) ? (row + 1) : row, (col + 1) % 9)) {
				return true;
			}
		} else {
			for (int value = 1; value < FILL_SIZE; value++) {
				if (isPromising(value, row, col)) {
					board.setValue(row, col, value);
					if (backTrackingAlgorithm((col == 8) ? (row + 1) : row, (col + 1) % 9)) {
						return true;
					} else {
						board.setValue(row, col, 0);
					}
				}
			}
		}

		return false; // backtrack trigger

	}

	private boolean isPromising(int value, int row, int col) {
		boolean result = true;
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board.getValue(row, i) == value || board.getValue(i, col) == value) {
				result = false;
			}
		}

		for (int i = getQuadPos(row); i < QUAD_SIZE + getQuadPos(row); i++) {
			for (int j = getQuadPos(col); j < QUAD_SIZE + getQuadPos(col); j++) {
				if (board.getValue(i, j) == value) {
					result = false;
				}
			}
		}
		return result;
	}

	public int getQuadPos(int row) {
		return row - (row % 3);
	}
}
