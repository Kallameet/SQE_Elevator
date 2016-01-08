package sqelevator.dummy;

import java.util.List;
import java.util.Observable;

import sqelevator.model.IElevatorInfo;
import sqelevator.model.IElevatorInfoProvider;

public class ElevatorInfoProviderDummy extends Observable implements IElevatorInfoProvider
{
	List<IElevatorInfo> _elevatorInfos;
		
	@Override
	public List<IElevatorInfo> getElevatorInfos()
	{
		return _elevatorInfos;
	}
	
	public void setElevatorInfos(List<IElevatorInfo> elevatorInfos)
	{
		_elevatorInfos = elevatorInfos;
	}
}
