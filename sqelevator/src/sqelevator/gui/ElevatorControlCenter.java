package sqelevator.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import sqelevator.model.IElevator;

public class ElevatorControlCenter extends JFrame implements IElevatorControlCenter {

	public static void main(String[] args) {
		ElevatorControlCenter gui = new ElevatorControlCenter(3);
		gui.setDirection(0, IElevator.ELEVATOR_DIRECTION_UP);
		gui.setDirection(1, IElevator.ELEVATOR_DIRECTION_DOWN);
		gui.setDirection(2, IElevator.ELEVATOR_DIRECTION_UNCOMMITTED);
		gui.setSpeed(0, 25);
	}
	
	private JPanel mainPanel;
	
	/*
	 * List containing the panels for all elevators
	 */
	List<IElevatorControl> _elevators;
	
	public ElevatorControlCenter(int numberOfElevators) {
		setTitle("Elevator Control Center");
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setResizable(true);
		setVisible(true);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		
		_elevators = new ArrayList<IElevatorControl>();
		for(int i = 0; i < numberOfElevators; i++)
		{
			ElevatorPanel panel = new ElevatorPanel(i + 1);
			_elevators.add(panel);
			mainPanel.add(panel);
		}
		
		mainPanel.validate();
		
	}

	@Override
	public void setDirection(int elevator, int data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setDirection(data);
	}

	@Override
	public void setWeight(int elevator, int data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setWeight(data);
	}

	@Override
	public void setSpeed(int elevator, int data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setSpeed(data);
	}

	@Override
	public void setDoorStatus(int elevator, int data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setDoorStatus(data);
	}

	@Override
	public void setTarget(int elevator, int floor) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setTarget(floor);
	}

	@Override
	public void setPosition(int elevator, int data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setPosition(data);
	}

	@Override
	public void setElevatorButtons(int elevator, boolean[] data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setElevatorButtons(data);
	}

	@Override
	public void setFloorButtonsDown(int elevator, boolean[] data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setFloorButtonsDown(data);
	}

	@Override
	public void setFloorButtonsUp(int elevator, boolean[] data) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setFloorButtonsUp(data);
	}

	@Override
	public void setFloorHeight(int elevator, int height) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setFloorHeight(height);
	}

	@Override
	public void setNumberOfFloors(int elevator, int floors) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setNumberOfFloors(floors);
	}

	@Override
	public void setTargetReached(int elevator, int target) {
		if(_elevators.size() > elevator)
			_elevators.get(elevator).setTargetReached(target);
	}

	@Override
	public int getDirection(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getTargetReached();
		else
			return -1;
	}

	@Override
	public int getWeight(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getWeight();
		else
			return -1;
	}

	@Override
	public int getSpeed(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getSpeed();
		else
			return -1;
	}

	@Override
	public int getDoorStatus(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getDoorStatus();
		else
			return -1;
	}

	@Override
	public int getTarget(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getTarget();
		else
			return -1;
	}

	@Override
	public int getPosition(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getPosition();
		else
			return -1;
	}

	@Override
	public boolean[] getElevatorButtons(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getElevatorButtons();
		else
			return null;
	}

	@Override
	public boolean[] getFloorButtonsDown(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getFloorButtonsDown();
		else
			return null;
	}

	@Override
	public boolean[] getFloorButtonsUp(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getFloorButtonsUp();
		else
			return null;
	}

	@Override
	public int getFloorHeight(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getFloorHeight();
		else
			return -1;
	}

	@Override
	public int getNumberOfFloors(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getNumberOfFloors();
		else
			return -1;
	}

	@Override
	public int getTargetReached(int elevator) {
		if(_elevators.size() > elevator)
			return _elevators.get(elevator).getTargetReached();
		else
			return -1;
	}
	
	

}
