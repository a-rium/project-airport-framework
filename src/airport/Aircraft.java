package airport;

public class Aircraft
{
	private int id;
	private int capacity;
	private int availableSeats;
	
	public Aircraft(int id, int capacity)
	{
		this.id = id;
		this.capacity = capacity;
		this.availableSeats = capacity;
	}
	
	public void bookSeat()
	{
		availableSeats -= 1;
	}
	
	public void freeSeat()
	{
		availableSeats += 1;
	}
	
	public boolean isFull()
	{
		return availableSeats == 0;
	}
}
