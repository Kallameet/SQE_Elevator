package sqelevator.gui;


public interface IElevatorControl {
	
	/**
	 * set the direction of the elevator
	 * @param data direction of the elevator
	 */
	public void setDirection(int data);
	
	/**
	 * set the weight of the elevator and the passengers inside
	 * @param data the weight of the elevator and the passengers inside
	 */
	public void setWeight(int data);

	/**
	 * speed of the elevator
	 * @param data the speed of the elevator
	 */
	public void setSpeed(int data);
	
	/**
	 * status of the doors
	 * @param data true if doors are closed otherwise false
	 */
	public void setDoors(int data);
	
	/**
	 * set the floor where the elevator stops next
	 * sets the flags and buttons are enabled
	 * @param data floor where the elevator stops next
	 */
	public void setTarget(int _floor);
	
	/**
	 * set the position of the elevator
	 * @param data position in feet where the elevator is
	 */
	public void setPosition(int data);
	
	/**
	 * change the status of the elevator buttons
	 * @param data states of the elevator buttons
	 */
	public void setElevatorButtons(boolean[] data);
	
	/**
	 * change the status of the down buttons of each floor
	 * @param data  states of the down buttons
	 */
	public void setFloorButtonsDown(boolean[] data);
	
	/**
	 * change the status of the up buttons of each floor
	 * @param data states of the up buttons
	 */
	public void setFloorButtonsUp(boolean[] data);
	
	/**
	 * set the height of the floor for the elevator position view
	 * @param _height height of the floor
	 */
	public void setFloorHeight(int height);
	
	/**
	 * set the number of floors for the elevator position view
	 * @param _floors number of floors
	 */
	public void setNumberOfFloors(int floors);
	
	/**
	 * when the target is reached state button of the floor 
	 * is set to reached and a new target can be set
	 */
	public void setTargetReached(int target);
	
}
