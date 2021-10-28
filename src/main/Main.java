package main;

public class Main {

	public static void main(String[] args) {
		MainWindow mw = new MainWindow();
		new Thread(mw).start();
	}
}
