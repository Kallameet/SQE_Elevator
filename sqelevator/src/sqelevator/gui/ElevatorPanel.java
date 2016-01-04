package sqelevator.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/*
 * Represents the view of a single elevator 
 */
public class ElevatorPanel extends JPanel implements IElevatorControl {

	int _number;
	int _numberOfFloors = 5;
	
	JPanel _mainPanel;
	JPanel _informationPanel;
	JPanel _positionAndButtonPanel;
	JPanel _positionPanel;
	JPanel _buttonPanel;
	JPanel _floorsPanel;
	
	JLabel _positionLabel;
	JLabel _positionLabelData;
	JLabel _directionLabel;
	JLabel _directionLabelData;
	JLabel _speedLabel;
	JLabel _speedLabelData;
	JLabel _weightLabel;
	JLabel _weightLabelData;
	JLabel _doorsLabel;
	JLabel _doorsLabelData;
	JLabel _targetLabel;
	JLabel _targetLabelData;
	JLabel _directionArrowUp;
	JLabel _directionArrowDown;
	JLabel _currentFloor;
	
	JToggleButton _modeButton;
	
	JToggleButton _floor0Button;
	JToggleButton _floor1Button;
	JToggleButton _floor2Button;
	JToggleButton _floor3Button;
	JToggleButton _floor4Button;
	JToggleButton _floor5Button;
	
	ImageIcon _arrowUp = new ImageIcon("res/img/arrow_up.png");
	ImageIcon _arrowDown = new ImageIcon("res/img/arrow_down.png");
	
	public ElevatorPanel(int number)
	{
		_number = number;
		setBorder(new TitledBorder(null, "Elevator " + number,TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(10, 10, 568, 50);
		
		// main Panel
		_mainPanel = new JPanel();
		_mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		_mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Button for mode
		_modeButton = new JToggleButton("Automatic");
		_modeButton.setSelected(false);
		_mainPanel.add(_modeButton);
		
		// information box
		_informationPanel = new JPanel();
		_informationPanel.setBorder(new TitledBorder(null, "Information",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_informationPanel.setLayout(new GridLayout(6,2));
		_mainPanel.add(_informationPanel);
		
		// labels for information box
		_positionLabel = new JLabel("position");
		_positionLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_positionLabel);
		
		_positionLabelData = new JLabel("0");
		_positionLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_positionLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_positionLabelData);
		
		_directionLabel = new JLabel("direction");
		_directionLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_directionLabel);
				
		_directionLabelData = new JLabel("0");
		_directionLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_directionLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_directionLabelData);
		
		_speedLabel = new JLabel("speed");
		_speedLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_speedLabel);
				
		_speedLabelData = new JLabel("0");
		_speedLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_speedLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_speedLabelData);
		
		_weightLabel = new JLabel("weight");
		_weightLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_weightLabel);
				
		_weightLabelData = new JLabel("0");
		_weightLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_weightLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_weightLabelData);
		
		_doorsLabel = new JLabel("doors");
		_doorsLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_doorsLabel);
				
		_doorsLabelData = new JLabel("0");
		_doorsLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_doorsLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_doorsLabelData);
		
		_targetLabel = new JLabel("target");
		_targetLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_targetLabel);
				
		_targetLabelData = new JLabel("0");
		_targetLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_targetLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_targetLabelData);
		
		// Panel for Positions and Buttons
		_positionAndButtonPanel = new JPanel();
		_positionAndButtonPanel.setLayout(new BoxLayout(_positionAndButtonPanel, BoxLayout.LINE_AXIS));
		
		_mainPanel.add(_positionAndButtonPanel);
		
		// Panel for Position/Direction
		_positionPanel = new JPanel();
		_positionPanel.setLayout(new BoxLayout(_positionPanel, BoxLayout.PAGE_AXIS));
		_positionPanel.setBorder(new TitledBorder(null, "Position / Direction",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_positionPanel.setAlignmentX(CENTER_ALIGNMENT);
		_positionAndButtonPanel.add(_positionPanel);
		_positionAndButtonPanel.add(Box.createRigidArea(new Dimension(5,0)));
		
		_directionArrowUp = new JLabel("");
		_directionArrowUp.setIcon(_arrowUp);
		_directionArrowUp.setBounds(10, 156, 35, 35);
		_positionPanel.add(_directionArrowUp);
		_positionPanel.add(Box.createRigidArea(new Dimension(150,0)));
		
		_currentFloor = new JLabel("0");
		_currentFloor.setFont(new Font("Arial", Font.BOLD, 40));
		_positionPanel.add(_currentFloor);
		
		_directionArrowDown = new JLabel("");
		_directionArrowDown.setIcon(_arrowDown);
		_directionArrowDown.setBounds(10, 156, 35, 35);
		_positionPanel.add(_directionArrowDown);
		
		// Panel for Elevator Buttons
		_buttonPanel = new JPanel();
		_buttonPanel.setLayout(new BoxLayout(_buttonPanel, BoxLayout.PAGE_AXIS));
		_buttonPanel.setBorder(new TitledBorder(null, "Buttons",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
		
		_floor4Button = new JToggleButton("4");
		_floor4Button.setSelected(false);
		_buttonPanel.add(_floor4Button);
		
		_floor3Button = new JToggleButton("3");
		_floor3Button.setSelected(false);
		_buttonPanel.add(_floor3Button);
		
		_floor2Button = new JToggleButton("2");
		_floor2Button.setSelected(false);
		_buttonPanel.add(_floor2Button);
		
		_floor1Button = new JToggleButton("1");
		_floor1Button.setSelected(false);
		_buttonPanel.add(_floor1Button);
		
		_floor0Button = new JToggleButton("0");
		_floor0Button.setSelected(false);

		_buttonPanel.add(_floor0Button);
		_positionAndButtonPanel.add(_buttonPanel);
		
		_floorsPanel = new JPanel();
		_floorsPanel.setLayout(new BoxLayout(_floorsPanel, BoxLayout.PAGE_AXIS));
		_floorsPanel.setBorder(new TitledBorder(null, "Floors",TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		for(int i = _numberOfFloors - 1; i >= 0;i--)
		{
			_floorsPanel.add(new FloorPanel(i));
		}
		
		_mainPanel.add(_floorsPanel);
		
		add(_mainPanel);
		setVisible(true);
		
	}

	@Override
	public void setPreferredSize(Dimension preferredSize) {
		super.setPreferredSize(new Dimension(300,500));
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(300,500);
	}

	@Override
	public void setDirection(int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWeight(int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpeed(int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDoors(int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(int _floor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setElevatorButtons(boolean[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFloorButtonsDown(boolean[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFloorButtonsUp(boolean[] data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFloorHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNumberOfFloors(int floors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTargetReached(int target) {
		// TODO Auto-generated method stub
		
	}
	
}
