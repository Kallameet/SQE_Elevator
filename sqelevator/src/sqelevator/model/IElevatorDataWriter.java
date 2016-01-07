package sqelevator.model;

public interface IElevatorDataWriter {

	public void setTarget(int elevatorNumber, int target);
	
	public void setCommittedDirection(int elevatorNumber, int direction);
}
