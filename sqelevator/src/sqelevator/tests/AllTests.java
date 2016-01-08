package sqelevator.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PollerTests.class, ElevatorControllerTests.class, ElevatorControlCenterTests.class })
public class AllTests
{

}
