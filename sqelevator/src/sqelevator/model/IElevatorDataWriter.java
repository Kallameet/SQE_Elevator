package sqelevator.model;

public interface IElevatorDataWriter {

	/**
	 * Sets the floor target of the specified elevator. 
	 * @param elevatorNumber elevator number whose target floor is being set
	 * @param target floor number which the specified elevator is to target
	 */
	public void setFloor(int elevatorNumber, int target);
	
	/**
	 * Sets the floor target of the specified elevator. 
	 * @param elevatorNumber elevator number whose target floor is being set
	 * @param target floor number which the specified elevator is to target
	 */
	public void setMode(int elevatorNumber, ElevatorMode elevatorMode);
}
