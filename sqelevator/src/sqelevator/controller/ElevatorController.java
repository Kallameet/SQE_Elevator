package sqelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import sqelevator.IElevator;
import sqelevator.gui.ElevatorControlCenter;
import sqelevator.gui.IElevatorControlCenter;
import sqelevator.model.ElevatorMode;
import sqelevator.model.IElevatorDataWriter;
import sqelevator.model.IElevatorInfo;
import sqelevator.model.IElevatorInfoProvider;

public class ElevatorController implements IElevatorUpdateListener, Observer {
	
	IElevatorDataWriter _elevatorDataWriter;
	IElevatorControlCenter _elevatorControlCenter;
	List<IElevatorInfo> _currentElevatorInfos;
	List<ElevatorMode> _elevatorModes;
	
	public ElevatorController(IElevatorDataWriter elevatorDataWriter)
	{
		_elevatorDataWriter = elevatorDataWriter;
		_elevatorModes = new ArrayList<ElevatorMode>();
	}

	@Override
	public void updateElevator(int elevatorNumber, ElevatorMode mode, int floor) {
		// set current mode for elevator
		_elevatorModes.set(elevatorNumber, mode);
		
		if(mode == ElevatorMode.MANUAL)
		{
			_elevatorDataWriter.setTarget(elevatorNumber, floor);
			
			IElevatorInfo currentElevatorInfo = _currentElevatorInfos.get(elevatorNumber);
			int currentFloor = currentElevatorInfo.get_currentFloor();
			int direction = calculateCommittedDirection(floor, currentFloor);
				
			_elevatorDataWriter.setCommittedDirection(elevatorNumber, direction);
		}				
	}
	
	private int calculateCommittedDirection(int target, int currentFloor) {
		int direction = IElevator.ELEVATOR_DIRECTION_UNCOMMITTED;
		
		if(target > currentFloor)
		{
			direction = IElevator.ELEVATOR_DIRECTION_UP;
		}
		else if(target < currentFloor)
		{
			direction = IElevator.ELEVATOR_DIRECTION_DOWN;
		}
		return direction;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		IElevatorInfoProvider poller = (IElevatorInfoProvider)arg0;
		
		_currentElevatorInfos = poller.getElevatorInfos();
		for(int i = 0; i < _currentElevatorInfos.size(); i++)
		{
			UpdateElevatorGUI(i, _currentElevatorInfos.get(i));
		}
		
		if(_elevatorModes.size() == 0)
		{
			for(int i = 0; i < _currentElevatorInfos.size(); i++)
			{
				_elevatorModes.add(ElevatorMode.MANUAL);
			}
		}
		
		for(int i = 0; i < _elevatorModes.size(); i++)
		{
			if(_elevatorModes.get(i) == ElevatorMode.AUTOMATIC)
			{
				AutomaticElevatorUpdate(i);
			}
		}
	}
	
	void AutomaticElevatorUpdate(int elevatorNumber)
	{
		IElevatorInfo elevatorInfo = _currentElevatorInfos.get(elevatorNumber);
		int currentFloor = elevatorInfo.get_currentFloor();
		int numberOfFloors = elevatorInfo.get_elevatorButtons().length;
		
		if(currentFloor == elevatorInfo.get_targetFloor() && elevatorInfo.get_doorStatus() == IElevator.ELEVATOR_DOORS_OPEN)
		{
			SetNextFloor(elevatorInfo,currentFloor + 1, numberOfFloors, elevatorNumber);
		}
	}
	
	void SetNextFloor(IElevatorInfo elevatorInfo, int nextFloor, int numberOfFloors, int elevatorNumber)
	{
		if(nextFloor <  numberOfFloors)
		{
			// check if we need to stop here
			if(elevatorInfo.get_elevatorButtons()[nextFloor] || 
					elevatorInfo.get_downButtons()[nextFloor] ||
					elevatorInfo.get_upButtons()[nextFloor])
			{
				_elevatorDataWriter.setCommittedDirection(elevatorNumber, calculateCommittedDirection(nextFloor, elevatorInfo.get_currentFloor()));
				_elevatorDataWriter.setTarget(elevatorNumber, nextFloor);
			}
			else
			{
				SetNextFloor(elevatorInfo,nextFloor + 1, numberOfFloors, elevatorNumber);
			}
		}
		else
		{
			_elevatorDataWriter.setCommittedDirection(elevatorNumber, calculateCommittedDirection(nextFloor, elevatorInfo.get_currentFloor()));
			_elevatorDataWriter.setTarget(elevatorNumber, 0);
		}
	}
	
	public void UpdateElevatorGUI(int elevatorNumber, IElevatorInfo elevatorInfo)
	{
		if (elevatorInfo.get_targetFloor() == elevatorInfo.get_currentFloor())
		{
			_elevatorDataWriter.setCommittedDirection(elevatorNumber, 2);
		}
		
		_elevatorControlCenter.setDirection(elevatorNumber, elevatorInfo.get_direction());
		_elevatorControlCenter.setElevatorButtons(elevatorNumber, elevatorInfo.get_elevatorButtons());
		_elevatorControlCenter.setFloorButtonsDown(elevatorNumber, elevatorInfo.get_downButtons());
		_elevatorControlCenter.setFloorButtonsUp(elevatorNumber, elevatorInfo.get_upButtons());
		_elevatorControlCenter.setFloorHeight(elevatorNumber, elevatorInfo.get_floorHeight());
		_elevatorControlCenter.setPosition(elevatorNumber, elevatorInfo.get_currentFloor());
		_elevatorControlCenter.setSpeed(elevatorNumber, elevatorInfo.get_speed());
		_elevatorControlCenter.setTarget(elevatorNumber, elevatorInfo.get_targetFloor());
		_elevatorControlCenter.setWeight(elevatorNumber, elevatorInfo.get_weight());
		_elevatorControlCenter.setDoorStatus(elevatorNumber, elevatorInfo.get_doorStatus());
	}

	public void setView(IElevatorControlCenter gui) {
		_elevatorControlCenter = gui;
	}

}
