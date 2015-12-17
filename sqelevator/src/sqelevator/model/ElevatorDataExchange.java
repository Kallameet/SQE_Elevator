package sqelevator.model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ElevatorDataExchange implements IElevatorDataReader, IElevatorDataWriter {

	private IElevator _elevator;
	
	public ElevatorDataExchange(IElevator elevator)
	{
		_elevator = elevator;
	}

	@Override
	public void setFloor(int elevatorNumber, int target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMode(int elevatorNumber, ElevatorMode elevatorMode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IElevatorInfo> getElevatorInfos() {
		try 
		{
			int numberOfElevators = _elevator.getElevatorNum();
			
			List<IElevatorInfo> _elevatorInfos = new ArrayList<IElevatorInfo>();
			
			for(int i = 0; i < numberOfElevators; i++)
			{
				_elevatorInfos.add(getElevatorInfo(i));
			}
			
			return _elevatorInfos;
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private IElevatorInfo getElevatorInfo(int elevatorNumber)
	{
		IElevatorInfo elevator = new ElevatorInfo();
		
		try 
		{
			elevator.set_currentFloor(_elevator.getElevatorFloor(elevatorNumber));
			elevator.set_speed(_elevator.getElevatorSpeed(elevatorNumber));
			elevator.set_direction(_elevator.getCommittedDirection(elevatorNumber));
			elevator.set_acceleration(_elevator.getElevatorAccel(elevatorNumber));
			elevator.set_doorStatus(_elevator.getElevatorDoorStatus(elevatorNumber));
			elevator.set_distance(_elevator.getElevatorPosition(elevatorNumber));
			elevator.set_weight(_elevator.getElevatorWeight(elevatorNumber));
			elevator.set_capacity(_elevator.getElevatorCapacity(elevatorNumber));
			elevator.set_targetFloor(_elevator.getTarget(elevatorNumber));
			elevator.set_floorHeight(_elevator.getFloorHeight());
			
			int numberOfFloors = _elevator.getFloorNum();
			boolean[] elevatorButtons = new boolean[numberOfFloors];
			boolean[] upButtons = new boolean[numberOfFloors];
			boolean[] downButtons = new boolean[numberOfFloors];
			
			for(int floor = 0; floor < numberOfFloors; floor++ )
			{
				elevatorButtons[floor] = _elevator.getElevatorButton(elevatorNumber, floor);
				upButtons[floor] = _elevator.getFloorButtonUp(floor);
				downButtons[floor] = _elevator.getFloorButtonDown(floor);
			}
			
			elevator.set_elevatorButtons(elevatorButtons);
			elevator.set_upButtons(upButtons);
			elevator.set_downButtons(downButtons);
			
		} catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elevator;
	}
	
}
