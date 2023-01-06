package main;

import javax.swing.SwingUtilities;

public class Main implements Runnable{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Main());
	}

	public void run() {
		
	}
}
