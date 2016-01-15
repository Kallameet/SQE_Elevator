package sqelevator;

import java.util.List;

import sqelevator.controller.ElevatorController;
import sqelevator.controller.ElevatorUpdateProvider;
import sqelevator.dummy.*;
import sqelevator.gui.ElevatorControlCenter;
import sqelevator.model.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ElevatorApplication {

	public static void main(String[] args) {
			IElevator elevatorDummy = new ManualModeElevatorDummy();
			IElevator elevator;
			try {
				elevator = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
				ElevatorDataExchange elevatorDataExchange = new ElevatorDataExchange(elevator);
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
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
