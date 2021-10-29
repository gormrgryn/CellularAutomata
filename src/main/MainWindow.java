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
		setBounds(100, 100, 500, 500);
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
		graphic2d.fillRect(0, 0, 500, 500);

		game = new Game(200, 200);
		Cell[][] field = game.GetField();
	    for(Cell[] fieldRow : field) {
	    	for(Cell cell : fieldRow) {
	    		graphic2d.setColor(cell.isAlive ? Color.BLACK : Color.WHITE);
	    		graphic2d.fillRect(cell.x*5, cell.y*5, 5, 5);
	    	}
	    }
	    game.NextGen();
    }

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}

}
