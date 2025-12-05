package java8LambdaBasics;

public class Greeter {
	
	public void greet() {
		System.out.print("Hey all");
	}
	
	public void greets(Greeting greeting) {
		greeting.perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter greeter = new Greeter();
		greeter.greet();
		
		Greeter greeters = new Greeter();
		PrintGreeting obj = new PrintGreeting();
		greeters.greets(obj);
		
		Greeting lambdaGreeting = () -> System.out.print("hey");
		
		Greeting innerClass = new Greeting() {
			public void perform() {
				System.out.print("Hey");
			}
		};
		
		lambdaGreeting.perform();
	}

}
