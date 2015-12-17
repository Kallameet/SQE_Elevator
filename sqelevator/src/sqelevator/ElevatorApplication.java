package sqelevator;

import sqelevator.dummy.*;
import sqelevator.model.*;

public class ElevatorApplication {

	public static void main(String[] args) {
			IElevator elevatorDummy = new ElevatorDummy();
			ElevatorDataExchange elevatorDataExchange = new ElevatorDataExchange(elevatorDummy);
			Poller poller = new Poller(elevatorDataExchange);
			poller.start();
	}
}
