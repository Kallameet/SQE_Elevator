package sqelevator.dummy;

import java.util.HashMap;
import java.util.Map;

import sqelevator.model.IElevatorDataWriter;

public class DataWriterDummy implements IElevatorDataWriter
{
	public Map targetMap = new HashMap();
	public Map directionMap = new HashMap();
	
	@Override
	public void setTarget(int elevatorNumber, int target)
	{
		targetMap.put(elevatorNumber, target);		
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction)
	{
		directionMap.put(elevatorNumber, direction);		
	}

}
