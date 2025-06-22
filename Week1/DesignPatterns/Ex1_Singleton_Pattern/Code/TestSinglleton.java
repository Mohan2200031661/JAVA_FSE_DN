package singleton;

public class TestSinglleton {
	
	public static void main(String args[])
	{
		Logger instance = Logger.getInstance();
		
		instance.Log("First instnce message");
		instance.PrintMsg();
		
		Logger instance1 = Logger.getInstance();
		
		instance.PrintMsg();
	}
	

}
