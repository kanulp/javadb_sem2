package driver;

import java.util.*;

public interface  DriverReader 
{
	business.Driver getDriver(String firstName);
	ArrayList<business.Driver> getDrivers();
	
}
