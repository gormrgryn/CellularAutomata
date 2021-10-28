package main;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.Game;
import game.Cell;

public class MainWindow extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	private Game game;
	
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 440);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);
		this.setVisible(true);
	}
	
	@Override
    public void paint(Graphics g) {
		Graphics2D graphic2d = (Graphics2D) g;
		graphic2d.setColor(Color.WHITE);
		graphic2d.fillRect(0, 0, 300, 300);
		
		int res = 21;
		game = new Game(res, res);
		Cell[][] field = game.GetField();
	    for(Cell[] fieldRow : field) {
	    	for(Cell cell : fieldRow) {
	    		graphic2d.setColor(cell.isAlive ? Color.WHITE : Color.BLACK);
	    		graphic2d.fillRect(cell.x*res, cell.y*res, res, res);
	    	}
	    }
		
    }

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

}
