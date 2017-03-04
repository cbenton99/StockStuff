import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {
	
	private double[] data;
	private final int PAD;
	
	protected static final int GRAPH_WIDTH = (GUI.F_WIDTH - ButtonPanel.BUTTON_WIDTH);
	private final Dimension GRAPH_DIM = new Dimension(GRAPH_WIDTH, GUI.F_HEIGHT);
	
	public GraphPanel() {
		this(new double[] {1,2,0,1,3,4,5,4,3,2,1});
	}
	
	public GraphPanel(double[] data) {
		this.data = data;
		this.PAD = (GRAPH_WIDTH / data.length);
		
		setPreferredSize(GRAPH_DIM);
	}
	
	public void paint(Graphics g) {
		double max = max(data);
		double min = min(data);
		double diff = max - min;
		
		for (int index = 0; index < data.length-1; index++) {
			g.setColor(Color.BLACK);
			int x1 = PAD * index;
			int x2 = PAD * (index + 1);
			int y1 = (int) ((max - data[index]) / diff * GUI.F_HEIGHT);
			int y2 = (int) ((max - data[index+1]) / diff * GUI.F_HEIGHT);
			
			if (index == 249 || index == 248 || index == 247) {
			//if (data[index] == max || data[index+1] == max) {
				g.setColor(Color.RED);
			}
			
			g.drawLine(x1, y1, x2, y2);
		}//end for loop
		
	}//end paint
	
	
	private double max(double[] data) {
		double max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}
		
		return max;
	}//end max
	
	private double min(double[] data) {
		double min = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] < min) {
				min = data[i];
			}
		}
		
		return min;
	}//end min
	
}//end class