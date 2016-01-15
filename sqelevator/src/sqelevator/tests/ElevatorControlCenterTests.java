package sqelevator.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sqelevator.IElevator;
import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.gui.ElevatorControlCenter;
import sqelevator.model.ElevatorInfo;
import sqelevator.model.IElevatorInfo;

public class ElevatorControlCenterTests
{
	@Test
	public void testDirectionUp()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDirection(0, IElevator.ELEVATOR_DIRECTION_UP);
		
		assertEquals(IElevator.ELEVATOR_DIRECTION_UP, center.getDirection(0));
	}
	
	@Test
	public void testDirectionDown()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDirection(0, IElevator.ELEVATOR_DIRECTION_DOWN);
		
		assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, center.getDirection(0));
	}
	
	@Test
	public void testDirectionUncommitted()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDirection(0, IElevator.ELEVATOR_DIRECTION_UNCOMMITTED);
		
		assertEquals(IElevator.ELEVATOR_DIRECTION_UNCOMMITTED, center.getDirection(0));
	}
	
	@Test
	public void testWeight()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setWeight(0, 200);
		
		assertEquals(200, center.getWeight(0));
	}
	
	@Test
	public void testSpeed()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setSpeed(0, 150);
		
		assertEquals(150, center.getSpeed(0));
	}
	
	@Test
	public void testDoorStatusOpen()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDoorStatus(0, IElevator.ELEVATOR_DOORS_OPEN);
		
		assertEquals(IElevator.ELEVATOR_DOORS_OPEN, center.getDoorStatus(0));
	}
	
	@Test
	public void testDoorStatusClosed()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDoorStatus(0, IElevator.ELEVATOR_DOORS_CLOSED);
		
		assertEquals(IElevator.ELEVATOR_DOORS_CLOSED, center.getDoorStatus(0));
	}
	
	@Test
	public void testDoorStatusOpening()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDoorStatus(0, IElevator.ELEVATOR_DOORS_OPENING);
		
		assertEquals(IElevator.ELEVATOR_DOORS_OPENING, center.getDoorStatus(0));
	}
	
	@Test
	public void testDoorStatusClosing()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setDoorStatus(0, IElevator.ELEVATOR_DOORS_CLOSING);
		
		assertEquals(IElevator.ELEVATOR_DOORS_CLOSING, center.getDoorStatus(0));
	}	
	
	@Test
	public void testTarget()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setTarget(0, 4);
		
		assertEquals(4, center.getTarget(0));
	}
	
	@Test
	public void testPosition()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setPosition(0, 5);
		
		assertEquals(5, center.getPosition(0));
	}
	
	@Test
	public void testElevatorButtons()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		boolean[] elevatorButtons = new boolean[4];	
		
		ElevatorInfo info = new ElevatorInfo();
		info.set_elevatorButtons(elevatorButtons);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
				
		for(int floor = 0; floor < 4; floor++ )
		{
			elevatorButtons[floor] = false || floor == 2;
		}
		
		center.setElevatorButtons(0, elevatorButtons);
		
		assertArrayEquals(new boolean []{false, false, true, false}, center.getElevatorButtons(0));
	}
	
	@Test
	public void testUpButtons()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		boolean[] elevatorButtons = new boolean[4];	
		
		ElevatorInfo info = new ElevatorInfo();
		info.set_elevatorButtons(elevatorButtons);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
				
		boolean[] upButtons = new boolean[4];			
		for(int floor = 0; floor < 4; floor++ )
		{
			upButtons[floor] = false || floor == 3;
		}
		
		center.setFloorButtonsUp(0, upButtons);
		
		assertArrayEquals(new boolean []{false, false, false, true}, center.getFloorButtonsUp(0));
	}
	
	@Test
	public void testDownButtons()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		boolean[] elevatorButtons = new boolean[4];	
		
		ElevatorInfo info = new ElevatorInfo();
		info.set_elevatorButtons(elevatorButtons);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
				
		boolean[] downButtons = new boolean[4];
		for(int floor = 0; floor < 4; floor++ )
		{
			downButtons[floor] = false || floor == 0;
		}
		
		center.setFloorButtonsDown(0, downButtons);
		
		assertArrayEquals(new boolean []{true, false, false, false}, center.getFloorButtonsDown(0));
	}
	
	@Test
	public void testFloorHeight()
	{
		ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
		
		ElevatorInfo info = new ElevatorInfo();
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorControlCenter center = new ElevatorControlCenter(infos, updateProvider);
		
		center.setFloorHeight(0, 50);
		
		assertEquals(50, center.getFloorHeight(0));
	}
}
