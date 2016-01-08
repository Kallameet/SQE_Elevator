package sqelevator.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.gui.ElevatorControlCenter;
import sqelevator.model.ElevatorInfo;
import sqelevator.model.IElevatorInfo;

public class ElevatorControlCenterTests
{
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
