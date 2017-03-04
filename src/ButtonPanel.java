import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	
	private JButton[] buttons;
	private ArrayList<String> trends;
	
	protected static final int BUTTON_WIDTH = 75;
	protected static final int BUTTON_HEIGHT = 40;
	
	private final Dimension BUTTON_DIM = new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT);
	private final Dimension B_PANEL_DIM = new Dimension(BUTTON_WIDTH, GUI.F_HEIGHT);
	
	public ButtonPanel() {
		populateTrendTypes();
		setPreferredSize(B_PANEL_DIM);
		buttons = new JButton[trends.size()];
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		for (int index = 0; index < trends.size(); index++) {
			buttons[index] = new JButton(trends.get(index));
			buttons[index].addActionListener(new ButtonListener());
			
			buttons[index].setPreferredSize(BUTTON_DIM);
			buttons[index].setMargin(new Insets(5,5,5,5));
			
			c.gridy = index;
			c.fill = GridBagConstraints.BOTH;
			add(buttons[index], c);
		}
		
	}//end ButtonPanel
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			System.out.println("button works");
			
		}
		
	}//end ButtonListener
	
	private void populateTrendTypes() {
		trends = new ArrayList<String>();
		
		trends.add("Sharp UP");
		trends.add("Sharp DOWN");
		trends.add("Round UP");
		trends.add("Round DOWN");
		trends.add("Multiple UP");
		trends.add("Multiple DOWN");
		trends.add("Choppy UP");
		trends.add("Choppy DOWN");
		trends.add("Flat UP");
		trends.add("Flat DOWN");
		trends.add("Gap UP");
		trends.add("Gap DOWN");
		trends.add("Gaps UP");
		trends.add("Gaps DOWN");
		
	}//end populateTrendTypes
	
}//end class
