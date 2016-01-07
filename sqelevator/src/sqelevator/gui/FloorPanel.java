package sqelevator.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.model.ElevatorMode;

public class FloorPanel extends JPanel {

	int _floorNumber;
	int _elevatorNumber;
	ElevatorUpdateProvider _updateProvider;
	
	JPanel _mainPanel;
	JToggleButton _buttonUp;
	JToggleButton _buttonDown;
	JButton _buttonGoTo;
	
	public FloorPanel(int floorNumber, int elevatorNumber, ElevatorUpdateProvider updateProvider)
	{
		_updateProvider = updateProvider;
		_elevatorNumber = elevatorNumber;
		_floorNumber = floorNumber;
		setBorder(new TitledBorder(null, "Floor " + floorNumber,TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(10, 10, 568, 50);
		
		// main Panel
		_mainPanel = new JPanel();
		_mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.LINE_AXIS));
		_mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		_buttonUp = new JToggleButton("Up");
		_buttonUp.setSelected(false);
		_buttonUp.setEnabled(false);
		_mainPanel.add(_buttonUp);
		
		_buttonDown = new JToggleButton("Down");
		_buttonDown.setSelected(false);
		_buttonDown.setEnabled(false);
		_mainPanel.add(_buttonDown);
		
		_buttonGoTo = new JButton("GO");
		_buttonGoTo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				_updateProvider.notifyChanged(_elevatorNumber, ElevatorMode.MANUAL, _floorNumber);
			}
		});
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
