package sqelevator.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sqelevator.model.ElevatorMode;


public class ElevatorUpdateProvider {
	
	List<IElevatorUpdateListener> listeners = new ArrayList<IElevatorUpdateListener>();
	
	public void addListener(IElevatorUpdateListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeListener(IElevatorUpdateListener listener)
	{
		listeners.remove(listener);
	}
	
	public void notifyChanged(int elevatorNumber, ElevatorMode mode, int floor)
	{
		for(IElevatorUpdateListener listener : listeners)
		{
			listener.updateElevator(elevatorNumber, mode, floor);
		}
	}
}
