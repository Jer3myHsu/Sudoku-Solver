
public class Sudoku {
	private int usersInput[][]= new int[9][9];
	private int solution[][] = new int[9][9];
	private long initalTime;
	private final long failTime = (long) Math.pow(10, 8) * 5;//0.5 seconds
	public Sudoku() {
	}
	public int getValue(int x, int y) {
		return solution[y][x];
	}
	public void setValue(int value, int x, int y) {
		this.usersInput[y][x] = value;
	}
	/**
	 * Return true if the number in sudoku with position x and y is a possible solution. Else return false
	 * @param x - x position of a number in sudoku
	 * @param y - y position of a number in sudoku
	 * @return Possible solution status
	 */
	private boolean check(int x, int y) {
		int xQuadrant = (x / 3) * 3 + 3;
		int yQuadrant = (y / 3) * 3 + 3;
		for (int i = (x / 3) * 3; i < xQuadrant; i++)
			for (int j = (y / 3) * 3; j < yQuadrant; j++)
				if (solution[y][x] == solution[j][i] && x != i && y != j)
					return false;
		for (int i = 0; i < 9; i++) {
			if ((solution[y][x] == solution[i][x] && i != y) || (solution[y][x] == solution[y][i] && i != x))
				return false;
		}
		return true;
	}
	/**
	 * Return true and solves sudoku. If can't be solved, return false without modifying sudoku
	 * @return Success status
	 */
	public boolean solveSudoku() {
		initalTime = System.nanoTime();
		boolean zero = false;
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				solution[j][i] = usersInput[j][i];
				if (usersInput[j][i] != 0) zero = true;
			}
		}
		return zero ? solveSudoku(0) : true;
	}
	private boolean solveSudoku(int depth) {
		if (System.nanoTime() - initalTime >= failTime) return false;
		int x = depth % 9;
		int y = depth / 9;
		if (solution[y][x] == 0) {
			for (int i = 1; i < 10; i++) {
				solution[y][x] = i;
				if (solveSudoku(depth)) return true;
			}
			solution[y][x] = 0;
		} else if (check(x, y))
			return depth == 80 ?  true : solveSudoku(depth + 1);
		return false;
	}
	public void print() {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.err.print(solution[j][i] + " ");
			}System.err.println();
		}System.err.println();
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.err.print(usersInput[j][i] + " ");
			}System.err.println();
		}System.err.println();
	}
}
