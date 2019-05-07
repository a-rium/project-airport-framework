package airport;

import java.time.ZoneId;

public class Airport {
	private String name;
	private ZoneId timeZone;
	
	public Airport(String name, ZoneId timeZone) {
		super();
		this.name = name;
		this.timeZone = timeZone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ZoneId getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(ZoneId timeZone) {
		this.timeZone = timeZone;
	}
	
	
}
