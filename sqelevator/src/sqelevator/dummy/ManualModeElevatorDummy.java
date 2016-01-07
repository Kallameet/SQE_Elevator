package sqelevator.dummy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import sqelevator.model.ElevatorInfo;
import sqelevator.model.IElevator;
import sqelevator.model.IElevatorInfo;

public class ManualModeElevatorDummy implements IElevator {
	
	final int NUMBER_OF_ELEVATORS = 3;
	final int NUMBER_OF_FLOORS = 5;
	
	List<IElevatorInfo> _dummyElevatorInfos;	
	
	public ManualModeElevatorDummy()
	{
		_dummyElevatorInfos = new ArrayList<IElevatorInfo>();
		for(int i = 0; i < NUMBER_OF_ELEVATORS; i++)
		{
			IElevatorInfo elevator = new ElevatorInfo();
			
			elevator.set_elevatorNumber(i);
			elevator.set_currentFloor(0);
			elevator.set_speed(12);
			elevator.set_direction(0);
			elevator.set_acceleration(20);
			elevator.set_doorStatus(2);
			elevator.set_distance(5);
			elevator.set_weight(94);
			elevator.set_capacity(120);
			
			boolean[] elevatorButtons = new boolean[NUMBER_OF_FLOORS];
			boolean[] upButtons = new boolean[NUMBER_OF_FLOORS];
			boolean[] downButtons = new boolean[NUMBER_OF_FLOORS];
			
			for(int floor = 0; floor < NUMBER_OF_FLOORS; floor++ )
			{
				elevatorButtons[floor] = false;
				upButtons[floor] = false;
				downButtons[floor] = false;
			}
			
			elevator.set_elevatorButtons(elevatorButtons);
			elevator.set_upButtons(upButtons);
			elevator.set_downButtons(downButtons);
			
			_dummyElevatorInfos.add(elevator);
		}
	}
	
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_direction();
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_acceleration();
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_elevatorButtons()[floor];
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_doorStatus();
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_currentFloor();
	}

	@Override
	public int getElevatorNum() throws RemoteException {
		return NUMBER_OF_ELEVATORS;
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		return (int) _dummyElevatorInfos.get(elevatorNumber).get_distance();
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_speed();
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		return (int) _dummyElevatorInfos.get(elevatorNumber).get_weight();
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		return (int) _dummyElevatorInfos.get(elevatorNumber).get_capacity();
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		return _dummyElevatorInfos.get(0).get_downButtons()[floor];
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		return _dummyElevatorInfos.get(0).get_upButtons()[floor];
	}

	@Override
	public int getFloorHeight() throws RemoteException {
		return 8;
	}

	@Override
	public int getFloorNum() throws RemoteException {
		return NUMBER_OF_FLOORS;
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		return false;
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		return _dummyElevatorInfos.get(elevatorNumber).get_targetFloor();
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		_dummyElevatorInfos.get(elevatorNumber).set_direction(direction);
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTarget(final int elevatorNumber, final int target) throws RemoteException {
		_dummyElevatorInfos.get(elevatorNumber).set_targetFloor(target);
		
		new java.util.Timer().schedule(
				new java.util.TimerTask() {
					@Override
					public void run(){
						_dummyElevatorInfos.get(elevatorNumber).set_currentFloor(target);
					}
				},
				1000
		);
	}

	@Override
	public long getClockTick() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
