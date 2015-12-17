package sqelevator.model;

public interface IElevatorInfo {

	int get_elevatorNumber();

	int get_currentFloor();

	int get_speed();

	int get_direction();

	int get_acceleration();

	int get_doorStatus();

	double get_distance();

	double get_weight();

	double get_capacity();
	
	int get_targetFloor();

	int get_floorHeight();

	boolean[] get_elevatorButtons();

	boolean[] get_downButtons();

	boolean[] get_upButtons();

	void set_elevatorNumber(int _elevatorNumber);

	void set_currentFloor(int _currentFloor);

	void set_speed(int _speed);

	void set_direction(int _direction);

	void set_acceleration(int _acceleration);

	void set_doorStatus(int _doorStatus);

	void set_distance(double _distance);

	void set_weight(double _weight);
	
	void set_capacity(double _capacity);

	void set_targetFloor(int _targetFloor);

	void set_floorHeight(int _floorHeight);

	void set_elevatorButtons(boolean[] _elevatorButtons);

	void set_downButtons(boolean[] _downButtons);

	void set_upButtons(boolean[] _upButtons);

}