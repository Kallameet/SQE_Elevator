package sqelevator.dummy;

import java.util.ArrayList;
import java.util.List;

import sqelevator.gui.IElevatorControlCenter;
import sqelevator.model.ElevatorInfo;
import sqelevator.model.IElevatorInfo;

public class ElevatorControlCenterDummy implements IElevatorControlCenter
{
	List<IElevatorInfo> _dummyElevatorInfos;
	
	public ElevatorControlCenterDummy(int elevators)
	{
		_dummyElevatorInfos = new ArrayList<IElevatorInfo>();
		
		for (int i = 0; i < elevators; i++)
		{
			_dummyElevatorInfos.add(new ElevatorInfo());
		}
	}
	
	@Override
	public void setDirection(int elevator, int data)
	{
		_dummyElevatorInfos.get(elevator).set_direction(data);		
	}

	@Override
	public int getDirection(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_direction();
	}

	@Override
	public void setWeight(int elevator, int data)
	{
		_dummyElevatorInfos.get(elevator).set_weight(data);
	}

	@Override
	public int getWeight(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_weight();
	}

	@Override
	public void setSpeed(int elevator, int data)
	{
		_dummyElevatorInfos.get(elevator).set_speed(data);
	}

	@Override
	public int getSpeed(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_speed();
	}

	@Override
	public void setDoorStatus(int elevator, int data)
	{
		_dummyElevatorInfos.get(elevator).set_doorStatus(data);
	}

	@Override
	public int getDoorStatus(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_doorStatus();
	}

	@Override
	public void setTarget(int elevator, int floor)
	{
		_dummyElevatorInfos.get(elevator).set_targetFloor(floor);
	}

	@Override
	public int getTarget(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_targetFloor();
	}

	@Override
	public void setPosition(int elevator, int data)
	{
		_dummyElevatorInfos.get(elevator).set_currentFloor(data);		
	}

	@Override
	public int getPosition(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_currentFloor();
	}

	@Override
	public void setElevatorButtons(int elevator, boolean[] data)
	{
		_dummyElevatorInfos.get(elevator).set_elevatorButtons(data);
		
	}

	@Override
	public boolean[] getElevatorButtons(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_elevatorButtons();
	}

	@Override
	public void setFloorButtonsDown(int elevator, boolean[] data)
	{
		_dummyElevatorInfos.get(elevator).set_downButtons(data);
		
	}

	@Override
	public boolean[] getFloorButtonsDown(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_downButtons();
	}

	@Override
	public void setFloorButtonsUp(int elevator, boolean[] data)
	{
		_dummyElevatorInfos.get(elevator).set_upButtons(data);		
	}

	@Override
	public boolean[] getFloorButtonsUp(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_upButtons();
	}

	@Override
	public void setFloorHeight(int elevator, int height)
	{
		_dummyElevatorInfos.get(elevator).set_floorHeight(height);		
	}

	@Override
	public int getFloorHeight(int elevator)
	{
		return _dummyElevatorInfos.get(elevator).get_floorHeight();
	}

	@Override
	public void setTargetReached(int elevator, int target)
	{}

	@Override
	public int getTargetReached(int elevator)
	{		
		return 0;
	}

}
