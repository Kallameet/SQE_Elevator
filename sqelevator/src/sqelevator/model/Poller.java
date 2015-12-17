package sqelevator.model;

import java.util.List;

public class Poller implements Runnable {

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
	
	public List<IElevatorInfo> getElevatorInfos()
	{
		return _elevatorInfos;
	}

}
