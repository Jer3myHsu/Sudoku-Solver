import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class Tile extends JTextArea {
	private Font font = new Font("Google Sans", Font.PLAIN, 32);
	private boolean userNumber = false;
	private int x;
	private int y;
	public Tile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.setText("0");
		this.setFont(font);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	}
	public int getPositionX() {
		return x;
	}
	public int getPositionY() {
		return y;
	}
	public void setValue(String arg) {
		super.setText(arg);
		if (arg.equals("0")) userNumber = false;
		else userNumber = true;
	}
	public void setBackground(Color color) {
		if (userNumber) super.setBackground(color);
		else super.setBackground(Color.WHITE);
	}
	
}
