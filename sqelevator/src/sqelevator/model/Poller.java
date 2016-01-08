package sqelevator.model;

import java.util.List;
import java.util.Observable;

public class Poller extends Observable implements Runnable, IElevatorInfoProvider  {

	private IElevatorDataReader _reader;
	
	private List<IElevatorInfo> _elevatorInfos;
	private int _interval = 500;
	private boolean _running = true;
	
	public Poller(IElevatorDataReader reader)
	{
		_reader = reader;
		// get inital elevators
		_elevatorInfos = _reader.getElevatorInfos();
	}
	
	@Override
	public void run() 
	{
		while(_running)
		{
			_elevatorInfos = _reader.getElevatorInfos();
			setChanged();
			notifyObservers();
			
			try 
			{
				Thread.sleep(_interval);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void start()
	{
		_running = true;
		new Thread(this).start();
	}
	

	public void stop()
	{
		_running = false;
	}
	
	/* (non-Javadoc)
	 * @see sqelevator.model.IElevatorInfoProvider#getElevatorInfos()
	 */
	@Override
	public List<IElevatorInfo> getElevatorInfos()
	{
		return _elevatorInfos;
	}

}
