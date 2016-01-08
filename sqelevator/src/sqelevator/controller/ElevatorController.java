package sqelevator.controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
	
	public ElevatorController(IElevatorDataWriter elevatorDataWriter)
	{
		_elevatorDataWriter = elevatorDataWriter;
	}

	@Override
	public void updateElevator(int elevatorNumber, ElevatorMode mode, int floor) {
		_elevatorDataWriter.setTarget(elevatorNumber, floor);
		
		IElevatorInfo currentElevatorInfo = _currentElevatorInfos.get(elevatorNumber);
		int currentFloor = currentElevatorInfo.get_currentFloor();
		int direction = 2;
		
		if(floor > currentFloor)
		{
			direction = 0;
		}
		else if(floor < currentFloor)
		{
			direction = 1;
		}
			
		_elevatorDataWriter.setCommittedDirection(elevatorNumber, direction);		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		IElevatorInfoProvider poller = (IElevatorInfoProvider)arg0;
		
		_currentElevatorInfos = poller.getElevatorInfos();
		for(int i = 0; i < _currentElevatorInfos.size(); i++)
		{
			UpdateElevatorGUI(i, _currentElevatorInfos.get(i));
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
