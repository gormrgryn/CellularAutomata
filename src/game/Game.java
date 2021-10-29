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
				int randomNum = ThreadLocalRandom.current().nextInt(0, 10);
				
				if (randomNum == 1) field[y][x] = new Cell(x, y, true);
				else field[y][x] = new Cell(x, y, false);
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
	public void NextGen() {
		Cell[][] newField = new Cell[rows][columns];
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				Cell currentCell = field[y][x];
				if (!currentCell.isAlive && GetNeighbours(x, y).length == 3) {
					newField[y][x] = new Cell(x, y, true); 
				} else if (currentCell.isAlive && (GetNeighbours(x, y).length < 2 || GetNeighbours(x, y).length > 3)) {
					newField[y][x] = new Cell(x, y, false);
				} else newField[y][x] = field[y][x];
			}
		}
		field = newField;
	}
	private Cell[] GetNeighbours(int x, int y) {
		Cell[] cells = {
                field[(y+1+rows) % rows][(x+columns) % columns],
                field[(y-1+rows) % rows][(x+columns) % columns],
                field[(y+rows) % rows][(x+1+columns) % columns],
                field[(y+rows) % rows][(x-1+columns) % columns],
                field[(y+1+rows) % rows][(x+1+columns) % columns],
                field[(y-1+rows) % rows][(x-1+columns) % columns],
                field[(y-1+rows) % rows][(x+1+columns) % columns],
                field[(y+1+rows) % rows][(x-1+columns) % columns]
		};
		return cells;
	}
}
