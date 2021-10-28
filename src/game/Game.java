package game;

import java.util.concurrent.ThreadLocalRandom;

public final class Game {
	private Cell[][] field;
	private int columns;
	private int rows;
	
	public Game(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		field = new Cell[rows][columns];
		
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
				
				if (randomNum == 1) field[y][x] = new Cell(x, y, true);
				else if (randomNum == 0) field[y][x] = new Cell(x, y, false);
			}
		}
	}
	public Cell[][] GetField() {
		Cell[][] newField = new Cell[rows][columns];
		for(int y = 0; y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				newField[y][x] = field[y][x];
			}
		}
		return newField;
	}
}
