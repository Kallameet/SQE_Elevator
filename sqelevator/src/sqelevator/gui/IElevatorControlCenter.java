package sqelevator.gui;


public interface IElevatorControlCenter {
	
	/**
	 * set the direction of the elevator
	 * @param data direction of the elevator
	 */
	public void setDirection(int elevator, int data);
	public int getDirection(int elevator);
	
	/**
	 * set the weight of the elevator and the passengers inside
	 * @param data the weight of the elevator and the passengers inside
	 */
	public void setWeight(int elevator, int data);
	public int getWeight(int elevator);
	/**
	 * speed of the elevator
	 * @param data the speed of the elevator
	 */
	public void setSpeed(int elevator, int data);
	public int getSpeed(int elevator);
	
	/**
	 * status of the doors
	 * @param data true if doors are closed otherwise false
	 */
	public void setDoorStatus(int elevator, int data);
	public int getDoorStatus(int elevator);
	
	/**
	 * set the floor where the elevator stops next
	 * sets the flags and buttons are enabled
	 * @param data floor where the elevator stops next
	 */
	public void setTarget(int elevator, int floor);
	public int getTarget(int elevator);
	
	/**
	 * set the position of the elevator
	 * @param data position in feet where the elevator is
	 */
	public void setPosition(int elevator, int data);
	public int getPosition(int elevator);
	
	/**
	 * change the status of the elevator buttons
	 * @param data states of the elevator buttons
	 */
	public void setElevatorButtons(int elevator, boolean[] data);
	public boolean[] getElevatorButtons(int elevator);
	
	/**
	 * change the status of the down buttons of each floor
	 * @param data  states of the down buttons
	 */
	public void setFloorButtonsDown(int elevator, boolean[] data);
	public boolean[] getFloorButtonsDown(int elevator);
	
	/**
	 * change the status of the up buttons of each floor
	 * @param data states of the up buttons
	 */
	public void setFloorButtonsUp(int elevator, boolean[] data);
	public boolean[] getFloorButtonsUp(int elevator);
	
	/**
	 * set the height of the floor for the elevator position view
	 * @param height height of the floor
	 */
	public void setFloorHeight(int elevator, int height);
	public int getFloorHeight(int elevator);
	
	/**
	 * set the number of floors for the elevator position view
	 * @param floors number of floors
	 */
	public void setNumberOfFloors(int elevator, int floors);
	public int getNumberOfFloors(int elevator);
	
	/**
	 * when the target is reached state button of the floor 
	 * is set to reached and a new target can be set
	 */
	public void setTargetReached(int elevator, int target);
	public int getTargetReached(int elevator);
}
