package sqelevator.gui;

import sqelevator.IElevator;
import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.model.*;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/*
 * Represents the view of a single elevator 
 */
public class ElevatorPanel extends JPanel implements IElevatorControl
{

	int _numberOfFloors;
	int _elevatorNumber;
	ElevatorUpdateProvider _updateProvider;

	JPanel _mainPanel;
	JPanel _modePanel;
	JPanel _informationPanel;
	JPanel _positionAndButtonPanel;
	JPanel _positionPanel;
	JPanel _buttonPanel;
	JPanel _floorsPanel;
	ArrayList<FloorPanel> _floors;

	JLabel _floorHeightLabel;
	JLabel _floorHeightLabelData;
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

	JToggleButton _modeButtonManual;
	JToggleButton _modeButtonAutomatic;

	JToggleButton _floor0Button;
	JToggleButton _floor1Button;
	JToggleButton _floor2Button;
	JToggleButton _floor3Button;
	JToggleButton _floor4Button;
	JToggleButton _floor5Button;
	ArrayList<JToggleButton> _elevatorButtons;

	ImageIcon _arrowUp = new ImageIcon("res/img/arrow_up.png");
	ImageIcon _arrowDown = new ImageIcon("res/img/arrow_down.png");
	ImageIcon _arrowEmpty = new ImageIcon("res/img/arrow_empty.png");

	public ElevatorPanel(int number, IElevatorInfo elevator, ElevatorUpdateProvider updateProvider)
	{
		_updateProvider = updateProvider;
		_elevatorNumber = number;
		setBorder(
				new TitledBorder(null, "Elevator " + (number + 1), TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(10, 10, 568, 50);

		// main Panel
		_mainPanel = new JPanel();
		_mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		_mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Buttons for mode
		_modePanel = new JPanel();
		_modePanel.setLayout(new BoxLayout(_modePanel, BoxLayout.LINE_AXIS));

		_modeButtonAutomatic = new JToggleButton("Automatic");
		_modeButtonAutomatic.setSelected(false);
		_modeButtonAutomatic.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!_modeButtonAutomatic.isSelected())
				{
					_modeButtonAutomatic.setSelected(true);
				}
				else
				{
					for(int i = 0; i < _floors.size(); i++)
						_floors.get(i).setButtonsEnabled(false);
					
					_modeButtonManual.setSelected(false);
					_updateProvider.notifyChanged(_elevatorNumber, ElevatorMode.AUTOMATIC, -1);
				}
			}
		});
		_modePanel.add(_modeButtonAutomatic);

		_modeButtonManual = new JToggleButton("Manual");
		_modeButtonManual.setSelected(true);
		_modeButtonManual.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!_modeButtonManual.isSelected())
				{
					_modeButtonManual.setSelected(true);
				}
				else
				{
					for(int i = 0; i < _floors.size(); i++)
						_floors.get(i).setButtonsEnabled(true);
					
					_modeButtonAutomatic.setSelected(false);
					_updateProvider.notifyChanged(_elevatorNumber, ElevatorMode.MANUAL, -1);
				}
			}
		});
		_modePanel.add(_modeButtonManual);

		_mainPanel.add(_modePanel);

		// information box
		_informationPanel = new JPanel();
		_informationPanel
				.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_informationPanel.setLayout(new GridLayout(6, 2));
		_mainPanel.add(_informationPanel);

		// labels for information box
		_floorHeightLabel = new JLabel("floor height");
		_floorHeightLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_floorHeightLabel);

		_floorHeightLabelData = new JLabel("0");
		_floorHeightLabelData.setHorizontalAlignment(SwingConstants.RIGHT);
		_floorHeightLabelData.setBounds(69, 115, 82, 14);
		_informationPanel.add(_floorHeightLabelData);

		_directionLabel = new JLabel("direction");
		_directionLabel.setBounds(6, 115, 53, 14);
		_informationPanel.add(_directionLabel);

		_directionLabelData = new JLabel("uncommitted");
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
		_positionPanel.setBorder(
				new TitledBorder(null, "Position / Direction", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_positionPanel.setAlignmentX(CENTER_ALIGNMENT);
		_positionAndButtonPanel.add(_positionPanel);
		_positionAndButtonPanel.add(Box.createRigidArea(new Dimension(5, 0)));

		_directionArrowUp = new JLabel("");
		_directionArrowUp.setIcon(_arrowEmpty);
		_directionArrowUp.setBounds(10, 156, 35, 35);
		_positionPanel.add(_directionArrowUp);
		_positionPanel.add(Box.createRigidArea(new Dimension(150, 0)));

		_currentFloor = new JLabel("0");
		_currentFloor.setFont(new Font("Arial", Font.BOLD, 40));
		_positionPanel.add(_currentFloor);

		_directionArrowDown = new JLabel("");
		_directionArrowDown.setIcon(_arrowEmpty);
		_directionArrowDown.setBounds(10, 156, 35, 35);
		_positionPanel.add(_directionArrowDown);

		// Panel for Elevator Buttons
		_elevatorButtons = new ArrayList<JToggleButton>();
		_buttonPanel = new JPanel();
		_buttonPanel.setLayout(new BoxLayout(_buttonPanel, BoxLayout.PAGE_AXIS));
		_buttonPanel.setBorder(new TitledBorder(null, "Buttons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		_buttonPanel.add(Box.createRigidArea(new Dimension(50, 0)));

		_numberOfFloors = elevator.get_elevatorButtons().length;

		for (int i = 0; i < _numberOfFloors; i++)
		{
			JToggleButton button = new JToggleButton(Integer.toString(i));
			button.setSelected(false);
			button.setEnabled(false);
			_elevatorButtons.add(button);
		}

		for (int i = _elevatorButtons.size() - 1; i >= 0; i--)
		{
			_buttonPanel.add(_elevatorButtons.get(i));
		}

		_positionAndButtonPanel.add(_buttonPanel);

		_floors = new ArrayList<FloorPanel>();
		_floorsPanel = new JPanel();
		_floorsPanel.setLayout(new BoxLayout(_floorsPanel, BoxLayout.PAGE_AXIS));
		_floorsPanel.setBorder(new TitledBorder(null, "Floors", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		for (int i = 0; i < _numberOfFloors; i++)
		{
			FloorPanel floor = new FloorPanel(i, _elevatorNumber, _updateProvider);
			_floors.add(floor);
		}

		for (int i = _numberOfFloors - 1; i >= 0; i--)
		{
			_floorsPanel.add(_floors.get(i));
		}

		_mainPanel.add(_floorsPanel);

		add(_mainPanel);
		setVisible(true);

	}

	@Override
	public void setPreferredSize(Dimension preferredSize)
	{
		super.setPreferredSize(new Dimension(300, 500));
	}

	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(300, 500);
	}

	@Override
	public void setDirection(int data)
	{
		_directionArrowUp.setIcon(_arrowEmpty);
		_directionArrowDown.setIcon(_arrowEmpty);

		if (data == IElevator.ELEVATOR_DIRECTION_UP)
		{
			_directionLabelData.setText("up");
			_directionArrowUp.setIcon(_arrowUp);
		} else if (data == IElevator.ELEVATOR_DIRECTION_DOWN)
		{
			_directionLabelData.setText("down");
			_directionArrowDown.setIcon(_arrowDown);
		} else if (data == IElevator.ELEVATOR_DIRECTION_UNCOMMITTED)
			_directionLabelData.setText("uncommitted");
		else
			_directionLabelData.setText("unknown direction");
	}

	@Override
	public void setWeight(int data)
	{
		_weightLabelData.setText(data + "");
	}

	@Override
	public void setSpeed(int data)
	{
		_speedLabelData.setText(data + "");
	}

	@Override
	public void setDoorStatus(int data)
	{
		if (data == IElevator.ELEVATOR_DOORS_OPEN)
			_doorsLabelData.setText("opened");
		else if (data == IElevator.ELEVATOR_DOORS_CLOSED)
			_doorsLabelData.setText("closed");
		else if (data == IElevator.ELEVATOR_DOORS_OPENING)
			_doorsLabelData.setText("opening");
		else if (data == IElevator.ELEVATOR_DOORS_CLOSING)
			_doorsLabelData.setText("closing");
		else
			_doorsLabelData.setText("status not known");
	}

	@Override
	public void setTarget(int floor)
	{
		_targetLabelData.setText(floor + "");
	}

	@Override
	public void setPosition(int data)
	{
		_currentFloor.setText(data + "");
	}

	@Override
	public void setElevatorButtons(boolean[] data)
	{
		for (int i = 0; i < _elevatorButtons.size(); i++)
		{
			_elevatorButtons.get(i).setSelected(data[i]);
		}
	}

	@Override
	public void setFloorButtonsDown(boolean[] data)
	{
		for (int i = 0; i < _floors.size(); i++)
			_floors.get(i).setDownSelected(data[i]);
	}

	@Override
	public void setFloorButtonsUp(boolean[] data)
	{
		for (int i = 0; i < _floors.size(); i++)
			_floors.get(i).setUpSelected(data[i]);
	}

	@Override
	public void setFloorHeight(int height)
	{
		_floorHeightLabelData.setText(height + "");
	}

	@Override
	public void setTargetReached(int target)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public int getDirection()
	{
		if (_directionLabelData.getText() == "up")
		{
			return IElevator.ELEVATOR_DIRECTION_UP;
		} else if (_directionLabelData.getText() == "down")
		{
			return IElevator.ELEVATOR_DIRECTION_DOWN;
		} else if (_directionLabelData.getText() == "uncommitted")
		{
			return IElevator.ELEVATOR_DIRECTION_UNCOMMITTED;
		} else
		{
			return -1;
		}
	}

	@Override
	public int getWeight()
	{
		return Integer.parseInt(_weightLabelData.getText());
	}

	@Override
	public int getSpeed()
	{
		return Integer.parseInt(_speedLabelData.getText());
	}

	@Override
	public int getDoorStatus()
	{
		if (_doorsLabelData.getText() == "opened")
		{
			return IElevator.ELEVATOR_DOORS_OPEN;
		} else if (_doorsLabelData.getText() == "closed")
		{
			return IElevator.ELEVATOR_DOORS_CLOSED;
		} else if (_doorsLabelData.getText() == "opening")
		{
			return IElevator.ELEVATOR_DOORS_OPENING;
		} else if (_doorsLabelData.getText() == "closing")
		{
			return IElevator.ELEVATOR_DOORS_CLOSING;
		} else
		{
			return -1;
		}
	}

	@Override
	public int getTarget()
	{
		return Integer.parseInt(_targetLabelData.getText());
	}

	@Override
	public int getPosition()
	{
		return Integer.parseInt(_currentFloor.getText());
	}

	@Override
	public boolean[] getElevatorButtons()
	{
		boolean[] buttons = new boolean[_numberOfFloors];

		for (int i = 0; i < _numberOfFloors; i++)
			buttons[i] = _elevatorButtons.get(i).isSelected();

		return buttons;
	}

	@Override
	public boolean[] getFloorButtonsDown()
	{
		boolean[] buttons = new boolean[_numberOfFloors];

		for (int i = 0; i < _numberOfFloors; i++)
			buttons[i] = _floors.get(i).getDownSelected();

		return buttons;
	}

	@Override
	public boolean[] getFloorButtonsUp()
	{
		boolean[] buttons = new boolean[_numberOfFloors];

		for (int i = 0; i < _numberOfFloors; i++)
			buttons[i] = _floors.get(i).getUpSelected();

		return buttons;
	}

	@Override
	public int getFloorHeight()
	{
		return Integer.parseInt(_floorHeightLabelData.getText());
	}

	@Override
	public int getTargetReached()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
