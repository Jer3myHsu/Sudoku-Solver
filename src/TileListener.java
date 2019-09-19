import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TileListener implements KeyListener {
	private Sudoku sudoku;
	public TileListener(Sudoku sudoku) {
		super();
		this.sudoku = sudoku;
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		Tile tile = (Tile) e.getSource();
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == '0') {
			tile.setText("0");
		} else if ('1' <= e.getKeyChar() && '9' >= e.getKeyChar()) {
			tile.setText(e.getKeyChar() + "");
		} else {
			tile.setText("0");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {}

}
