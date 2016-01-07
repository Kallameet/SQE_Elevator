package sqelevator.controller;

import sqelevator.model.ElevatorMode;


public interface IElevatorUpdateListener {
	void updateElevator(int elevator, ElevatorMode mode, int floor);
}
