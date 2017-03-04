import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	
	protected static final int F_WIDTH = 900;
	protected static final int F_HEIGHT = 520;
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(F_WIDTH, F_HEIGHT+30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout());
	    frame.setLocationRelativeTo(null);
	    frame.setResizable(true);
	    
	    addComponents(panel);
	    frame.add(panel);
	    
	    frame.setVisible(true);
	}
	
	
	public void addComponents(Container pane) {
		
		pane.setLayout(null);
		
		ButtonPanel bp = new ButtonPanel();
		bp.setBounds(0, 0, ButtonPanel.BUTTON_WIDTH*2, F_HEIGHT);
		pane.add(bp);
		
		CandleStickGraph cs = new CandleStickGraph();
		cs.setBounds(ButtonPanel.BUTTON_WIDTH*2, 0, GraphPanel.GRAPH_WIDTH, F_HEIGHT);
		pane.add(cs);
		
		/*
		GraphPanel gp = new GraphPanel(test);
		gp.setBounds(ButtonPanel.BUTTON_WIDTH*2, 0, GraphPanel.GRAPH_WIDTH, F_HEIGHT);
		pane.add(gp);
		*/
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		GUI g = new GUI();
	}
	
	
}
