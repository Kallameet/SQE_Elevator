package sqelevator;

import java.util.List;

import sqelevator.controller.ElevatorController;
import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.dummy.*;
import sqelevator.gui.ElevatorControlCenter;
import sqelevator.model.*;

public class ElevatorApplication {

	public static void main(String[] args) {
			IElevator elevatorDummy = new ManualModeElevatorDummy();
			ElevatorDataExchange elevatorDataExchange = new ElevatorDataExchange(elevatorDummy);
			Poller poller = new Poller(elevatorDataExchange);	
			
			ElevatorController elevatorController = new ElevatorController(elevatorDataExchange);
			poller.addObserver(elevatorController);
			
			// get initial elevator infos(count and number of floors)
			List<IElevatorInfo> elevatorInfos = poller.getElevatorInfos();
			ElevatorUpdateProvider updateProvider = new ElevatorUpdateProvider();
			updateProvider.addListener(elevatorController);
			ElevatorControlCenter gui = new ElevatorControlCenter(elevatorInfos, updateProvider);
			elevatorController.setView(gui);
			
			poller.start();
	}
}
