package sqelevator.model;

import java.util.Observable;

public class ElevatorInfo extends Observable implements IElevatorInfo
{
	public static final int NUMBER_OF_FLOORS = 5;
	
	private int _elevatorNumber = 0;
	
	private int _currentFloor = -1;
	
	private int _speed = 0;
	
	private int _direction = 0;
	
	private int _acceleration = 0;
	
	private int _doorStatus = 0;
	
	private double _distance = 0;
	
	private double _weight = 0;
	
	private double _capacity = 0;
	
	private int _targetFloor = 0;
	
	private int _floorHeight = 0;

	private boolean[] _elevatorButtons = new boolean[NUMBER_OF_FLOORS];
	
	private boolean[] _downButtons = new boolean[NUMBER_OF_FLOORS];
	
	private boolean[] _upButtons = new boolean[NUMBER_OF_FLOORS];

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_elevatorNumber()
	 */
	@Override
	public int get_elevatorNumber() {
		return _elevatorNumber;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_currentFloor()
	 */
	@Override
	public int get_currentFloor() {
		return _currentFloor;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_speed()
	 */
	@Override
	public int get_speed() {
		return _speed;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_direction()
	 */
	@Override
	public int get_direction() {
		return _direction;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_acceleration()
	 */
	@Override
	public int get_acceleration() {
		return _acceleration;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_doorStatus()
	 */
	@Override
	public int get_doorStatus() {
		return _doorStatus;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_distance()
	 */
	@Override
	public double get_distance() {
		return _distance;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_weight()
	 */
	@Override
	public double get_weight() {
		return _weight;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_targetFloor()
	 */
	@Override
	public int get_targetFloor() {
		return _targetFloor;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_floorHeight()
	 */
	@Override
	public int get_floorHeight() {
		return _floorHeight;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_elevatorButtons()
	 */
	@Override
	public boolean[] get_elevatorButtons() {
		return _elevatorButtons;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_downButtons()
	 */
	@Override
	public boolean[] get_downButtons() {
		return _downButtons;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#get_upButtons()
	 */
	@Override
	public boolean[] get_upButtons() {
		return _upButtons;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_elevatorNumber(int)
	 */
	@Override
	public void set_elevatorNumber(int _elevatorNumber) {
		this._elevatorNumber = _elevatorNumber;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_currentFloor(int)
	 */
	@Override
	public void set_currentFloor(int _currentFloor) {
		this._currentFloor = _currentFloor;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_speed(double)
	 */
	@Override
	public void set_speed(int _speed) {
		this._speed = _speed;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_direction(int)
	 */
	@Override
	public void set_direction(int _direction) {
		this._direction = _direction;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_acceleration(double)
	 */
	@Override
	public void set_acceleration(int _acceleration) {
		this._acceleration = _acceleration;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_doorStatus(int)
	 */
	@Override
	public void set_doorStatus(int _doorStatus) {
		this._doorStatus = _doorStatus;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_distance(double)
	 */
	@Override
	public void set_distance(double _distance) {
		this._distance = _distance;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_weight(double)
	 */
	@Override
	public void set_weight(double _weight) {
		this._weight = _weight;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_targetFloor(int)
	 */
	@Override
	public void set_targetFloor(int _targetFloor) {
		this._targetFloor = _targetFloor;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_floorHeight(int)
	 */
	@Override
	public void set_floorHeight(int _floorHeight) {
		this._floorHeight = _floorHeight;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_elevatorButtons(boolean[])
	 */
	@Override
	public void set_elevatorButtons(boolean[] _elevatorButtons) {
		this._elevatorButtons = _elevatorButtons;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_downButtons(boolean[])
	 */
	@Override
	public void set_downButtons(boolean[] _downButtons) {
		this._downButtons = _downButtons;
	}

	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfo#set_upButtons(boolean[])
	 */
	@Override
	public void set_upButtons(boolean[] _upButtons) {
		this._upButtons = _upButtons;
	}

	@Override
	public double get_capacity() {
		return _capacity;
	}

	@Override
	public void set_capacity(double _capacity) {
		this._capacity = _capacity;
	}

	
}
