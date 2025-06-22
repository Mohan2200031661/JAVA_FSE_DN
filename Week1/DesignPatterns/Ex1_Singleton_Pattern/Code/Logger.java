package singleton;

public class Logger {
	
	private static Logger instance;
	
	private String testMessage;
	
	private Logger() {}
	
	public static Logger getInstance()
	{
		if(instance==null)
		{
			instance = new Logger();
		}
		
		return instance;
	}
	
	public void Log(String Message)
	{
		this.testMessage = Message;
	}
	
	public void PrintMsg()
	{
		System.out.println(testMessage);
	}

}
