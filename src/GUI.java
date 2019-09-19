import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	public static void main(String[] args) {
		final Color green = Color.decode("#B7FF99");
		final Color red = Color.decode("#FF7F7F");
		Sudoku sudoku = new Sudoku();
		JFrame frame = new JFrame("Sudoku");
		JPanel mainPanel = new JPanel();
		JPanel subPanel[] = new JPanel[9];
		Tile tile[][] = new Tile[9][9];
		mainPanel.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < subPanel.length; i++) {
			subPanel[i] = new JPanel();
			subPanel[i].setLayout(new GridLayout(3, 3));
			subPanel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			subPanel[i].setBackground(Color.BLACK);
			mainPanel.add(subPanel[i]);
		}
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile.length; j++) {
				tile[j][i] = new Tile(i, j);
				tile[j][i].addKeyListener(new KeyListener() {
					@Override
					public void keyTyped(KeyEvent e) {}
					@Override
					public void keyReleased(KeyEvent e) {
						Tile thisTile = (Tile) e.getSource();
						boolean solvable = false;
						if ('1' <= e.getKeyChar() && '9' >= e.getKeyChar()) {
							thisTile.setValue(e.getKeyChar() + "");
							sudoku.setValue(Integer.parseInt(thisTile.getText()), thisTile.getPositionX(), thisTile.getPositionY());
						} else {
							thisTile.setValue("0");
						}
						sudoku.setValue(Integer.parseInt(thisTile.getText()), thisTile.getPositionX(), thisTile.getPositionY());
						solvable = sudoku.solveSudoku();
						for (int i = 0; i < tile.length; i++) {
							for (int j = 0; j < tile.length; j++) {
								tile[j][i].setText(sudoku.getValue(i, j) + "");
								if (solvable) {
									tile[j][i].setBackground(green);
								} else {
									tile[j][i].setBackground(red);
								}
							}
						}
						
					}
					@Override
					public void keyPressed(KeyEvent e) {}
				});
				subPanel[(int) (j/3 + Math.floor(i/3) * 3)].add(tile[j][i]);
			}
		}
		mainPanel.setBackground(Color.BLACK);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(400, 400));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
