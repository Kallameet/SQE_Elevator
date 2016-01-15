package sqelevator.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sqelevator.dummy.ElevatorDummy;
import sqelevator.model.ElevatorDataExchange;
import sqelevator.model.IElevator;
import sqelevator.model.IElevatorInfo;
import sqelevator.model.Poller;


public class PollerTests
{
	IElevator elevatorDummy;
	ElevatorDataExchange elevatorDataExchange;
	Poller poller;
	
	@Before
	public void setUp() throws Exception
	{
		elevatorDummy = new ElevatorDummy();		
		elevatorDataExchange = new ElevatorDataExchange(elevatorDummy);
		poller = new Poller(elevatorDataExchange);
		poller.start();
	}
	
	@After
	public void tearDown() throws Exception
	{
		poller.stop();
		
		poller = null;
		elevatorDataExchange = null;
		elevatorDummy = null;		
	}
	

	@Test
	public void testGetCurrentFloor()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(2, info.get(2).get_currentFloor());		
	}
	
	@Test
	public void testGetSpeed()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(12, info.get(2).get_speed());		
	}

	@Test
	public void testGetDirection()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(0, info.get(2).get_direction());		
	}

	@Test
	public void testGetAcceleration()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(20, info.get(2).get_acceleration());		
	}

	@Test
	public void testGetDoorStatus()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(1, info.get(2).get_doorStatus());		
	}

	@Test
	public void testGetDistance()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(5, info.get(2).get_distance(), 0.1);		
	}

	@Test
	public void testGetWeight()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(94, info.get(2).get_weight(), 0.1);		
	}

	@Test
	public void testGetCapacity()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(120, info.get(2).get_capacity(), 0.1);		
	}

	@Test
	public void testGetTargetFloor()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(4, info.get(2).get_targetFloor());		
	}

	@Test
	public void testGetFloorHeight()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertEquals(8, info.get(2).get_floorHeight());		
	}
	
	@Test
	public void testGetUpButtons()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertArrayEquals(new boolean []{false, false, false, true, false}, info.get(1).get_upButtons());
	}
	
	@Test
	public void testGetElevatorButtons()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertArrayEquals(new boolean []{false, false, true, false, false}, info.get(1).get_elevatorButtons());
	}

	@Test
	public void testGetDownButtons()
	{			
		List<IElevatorInfo> info = poller.getElevatorInfos();		
		assertArrayEquals(new boolean []{false, false, false, false, true}, info.get(1).get_downButtons());
	}
}
