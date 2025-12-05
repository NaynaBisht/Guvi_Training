package com.app.work;

public class JobThread extends Thread{
	
	FileReadOperations obj = new FileReadOperations();
	
	JobThread(){
		
	}
	
	
	public JobThread(String name) {
		super(name);
	}
	public void run() {
		System.out.print("Inside run");
		
		try {
			obj.readFile();
			
		}catch(FileNotFoundException e){
			
		}
		
		System.out.print(isAlive());
	}

}
