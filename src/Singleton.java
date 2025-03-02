
public class Singleton {
	
	private static Singleton singletonInstance;
	
	private Singleton() {	
		System.out.println("This is a singleton constructor");
	}
	
	public static Singleton getInstance() {
		if (singletonInstance == null) 
			singletonInstance = new Singleton();
		return singletonInstance;
	}
	
	public void doSomething(){
		System.out.println("This is a public method of a singleton class");
	}
	
	public static void main(String args[]) {
		Singleton sin = Singleton.getInstance();
		Singleton sin2 = Singleton.getInstance();
		
		System.out.println("Are both instances the same ? " + sin.toString() + " " + sin2.toString());
		sin.doSomething();
	}
}
