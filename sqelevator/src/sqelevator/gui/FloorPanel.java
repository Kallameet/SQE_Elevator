package sqelevator.gui;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FloorPanel extends JPanel {

	int _number;
	
	JPanel _mainPanel;
	JToggleButton _buttonUp;
	JToggleButton _buttonDown;
	JButton _buttonGoTo;
	
	public FloorPanel(int number)
	{
		_number = number;
		setBorder(new TitledBorder(null, "Floor " + number,TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(10, 10, 568, 50);
		
		// main Panel
		_mainPanel = new JPanel();
		_mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.LINE_AXIS));
		_mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		_buttonUp = new JToggleButton("Up");
		_buttonUp.setSelected(false);
		_mainPanel.add(_buttonUp);
		
		_buttonDown = new JToggleButton("Down");
		_buttonDown.setSelected(false);
		_mainPanel.add(_buttonDown);
		
		_buttonGoTo = new JButton("GO");
		_mainPanel.add(_buttonGoTo);
		add(_mainPanel);
	}
	
	public void setUpSelected(boolean data)
	{
		_buttonUp.setSelected(data);
	}
	
	public void setDownSelected(boolean data)
	{
		_buttonDown.setSelected(data);
	}
	
	public void setButtonsEnabled(boolean data)
	{
		_buttonDown.setEnabled(data);
		_buttonUp.setEnabled(data);
		_buttonGoTo.setEnabled(data);
	}
	
	public boolean getUpSelected()
	{
		return _buttonUp.isSelected();
	}
	
	public boolean getDownSelected()
	{
		return _buttonDown.isSelected();
	}
}
