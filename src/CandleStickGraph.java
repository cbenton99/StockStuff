import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

@SuppressWarnings("serial")
public class CandleStickGraph extends JPanel {

	private DataPoint[] data;
	private final int PAD;

	protected static final int GRAPH_WIDTH = (GUI.F_WIDTH - ButtonPanel.BUTTON_WIDTH);
	private final Dimension GRAPH_DIM = new Dimension(GRAPH_WIDTH, GUI.F_HEIGHT);

	public CandleStickGraph() {
		File file = new File("AAPL.txt");
		DataPoint[] test = new DataPoint[250];
		try {
			Scanner in = new Scanner(file);
			for (int i = test.length - 1; i >= 0; i--) {
				DataPoint d = new DataPoint();
				d.setDate(in.next());
				d.setOpen(in.nextDouble());
				d.setHigh(in.nextDouble());
				d.setLow(in.nextDouble());
				d.setClose(in.nextDouble());
				d.setVolume(in.nextInt());
				test[i] = d;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.data = test;
		this.PAD = (GRAPH_WIDTH / data.length);

		setPreferredSize(GRAPH_DIM);

	}

	public void paint(Graphics g) {
		double max = max(data);
		double min = min(data);
		double diff = max - min;
		int y = 0;
		int height = 0;

		for (int index = 0; index < data.length - 1; index++) {
			//draw line
			g.setColor(Color.BLACK);
			int x1 = PAD * index;
			int x2 = PAD * index;
			int y1 = (int) ((max - data[index].getHigh()) / diff * GUI.F_HEIGHT);
			int y2 = (int) ((max - data[index].getLow()) / diff * GUI.F_HEIGHT);
			g.drawLine(x1, y1, x2, y2);
			
			//draw rectangle
			int x = (PAD * index) - 1;
			y = (int) ((max - data[index].getOpen()) / diff * GUI.F_HEIGHT);
			int width = PAD;
			height = (int) ((max - data[index].getClose()) / diff * GUI.F_HEIGHT) - y;
			
			if (data[index].getClose() > data[index].getOpen()) {
				y = (int) ((max - data[index].getClose()) / diff * GUI.F_HEIGHT);
				height = (int) ((max - data[index].getOpen()) / diff * GUI.F_HEIGHT) - y;
				g.drawRect(x, y, width, height);
				g.setColor(Color.GREEN);
			}
			
			else {
				y = (int) ((max - data[index].getOpen()) / diff * GUI.F_HEIGHT);
				height = (int) ((max - data[index].getClose()) / diff * GUI.F_HEIGHT) - y;
				g.drawRect(x, y, width, height);
				g.setColor(Color.RED);
			}
			
			
			g.fillRect(x, y, width, height);
			
			
			
		} // end for loop

	}// end paint

	private double max(DataPoint[] data) {
		double max = data[0].getHigh();
		for (int i = 1; i < data.length; i++) {
			if (data[i].getHigh() > max) {
				max = data[i].getHigh();
			}
		}

		return max;
	}// end max

	private double min(DataPoint[] data) {
		double min = data[0].getLow();
		for (int i = 1; i < data.length; i++) {
			if (data[i].getLow() < min) {
				min = data[i].getLow();
			}
		}

		return min;
	}// end min

}// end class