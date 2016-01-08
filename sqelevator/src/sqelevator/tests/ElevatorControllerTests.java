package sqelevator.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sqelevator.controller.ElevatorController;
import sqelevator.dummy.DataWriterDummy;
import sqelevator.dummy.ElevatorControlCenterDummy;
import sqelevator.dummy.ElevatorInfoProviderDummy;
import sqelevator.model.ElevatorInfo;
import sqelevator.model.ElevatorMode;
import sqelevator.model.IElevatorInfo;

public class ElevatorControllerTests
{
	@Test
	public void UpdateElevatorTest_TargetIsSameFloorAsCurrent()
	{	
		//arrange
		DataWriterDummy dataWriter = new DataWriterDummy();
		
		int elevators = 1;
		ElevatorControlCenterDummy controlCenter = new ElevatorControlCenterDummy(elevators);
				
		ElevatorInfo info = new ElevatorInfo();
		info.set_currentFloor(3);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorInfoProviderDummy provider = new ElevatorInfoProviderDummy();
		provider.setElevatorInfos(infos);
		
		ElevatorController controller = new ElevatorController(dataWriter);
		controller.setView(controlCenter);
		
		controller.update(provider, null);
		
		//act
		controller.updateElevator(0, ElevatorMode.MANUAL, 3);
		
		//assert
		assertEquals(3, dataWriter.targetMap.get(0));
		assertEquals(2, dataWriter.directionMap.get(0));	
	}
	
	@Test
	public void UpdateElevatorTest_TargetIsLowerFloorAsCurrent()
	{	
		//arrange
		DataWriterDummy dataWriter = new DataWriterDummy();
		
		int elevators = 1;
		ElevatorControlCenterDummy controlCenter = new ElevatorControlCenterDummy(elevators);
				
		ElevatorInfo info = new ElevatorInfo();
		info.set_currentFloor(3);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorInfoProviderDummy provider = new ElevatorInfoProviderDummy();
		provider.setElevatorInfos(infos);
		
		ElevatorController controller = new ElevatorController(dataWriter);
		controller.setView(controlCenter);
		
		controller.update(provider, null);
		
		//act
		controller.updateElevator(0, ElevatorMode.MANUAL, 1);
		
		//assert
		assertEquals(1, dataWriter.targetMap.get(0));
		assertEquals(1, dataWriter.directionMap.get(0));	
	}
	
	@Test
	public void UpdateElevatorTest_TargetIsHigherFloorAsCurrent()
	{	
		//arrange
		DataWriterDummy dataWriter = new DataWriterDummy();
		
		int elevators = 1;
		ElevatorControlCenterDummy controlCenter = new ElevatorControlCenterDummy(elevators);
				
		ElevatorInfo info = new ElevatorInfo();
		info.set_currentFloor(3);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorInfoProviderDummy provider = new ElevatorInfoProviderDummy();
		provider.setElevatorInfos(infos);
		
		ElevatorController controller = new ElevatorController(dataWriter);
		controller.setView(controlCenter);
		
		controller.update(provider, null);
		
		//act
		controller.updateElevator(0, ElevatorMode.MANUAL, 5);
		
		//assert
		assertEquals(5, dataWriter.targetMap.get(0));
		assertEquals(0, dataWriter.directionMap.get(0));	
	}
	
	@Test
	public void UpdateGuiTest()
	{	
		//arrange
		DataWriterDummy dataWriter = new DataWriterDummy();
		
		int elevators = 1;
		ElevatorControlCenterDummy controlCenter = new ElevatorControlCenterDummy(elevators);
				
		ElevatorInfo info = new ElevatorInfo();
		info.set_currentFloor(3);
		info.set_targetFloor(3);
		info.set_direction(1);
		info.set_floorHeight(10);
		info.set_speed(30);
		info.set_weight(100);
		info.set_doorStatus(2);
		List<IElevatorInfo> infos = new ArrayList<IElevatorInfo>();
		infos.add(info);
		
		ElevatorInfoProviderDummy provider = new ElevatorInfoProviderDummy();
		provider.setElevatorInfos(infos);
		
		ElevatorController controller = new ElevatorController(dataWriter);
		controller.setView(controlCenter);
				
		//act
		controller.update(provider, null);
		
		//assert
		assertEquals(info.get_currentFloor(), controlCenter.getPosition(0));
		assertEquals(info.get_targetFloor(), controlCenter.getTarget(0));
		assertEquals(info.get_direction(), controlCenter.getDirection(0));
		assertEquals(info.get_floorHeight(), controlCenter.getFloorHeight(0));
		assertEquals(info.get_speed(), controlCenter.getSpeed(0));
		assertEquals(info.get_weight(), controlCenter.getWeight(0));
		assertEquals(info.get_doorStatus(), controlCenter.getDoorStatus(0));
		
		assertEquals(2, dataWriter.directionMap.get(0));
	}

}
