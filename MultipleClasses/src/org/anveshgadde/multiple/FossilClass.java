package org.anveshgadde.multiple;

public class FossilClass{
	public static void main(String []args){
	
	Impala impala = new Impala();
	
	impala.start();
	
	Cricket cricket = new Cricket();
	
	cricket.batting();
	cricket.bowling();
		
	}
}

class Impala{
	void start(){
		System.out.println("Engine Started!");
		}
}

class Cricket{
	void batting(){
	System.out.println("Batting first!");
	}
	
	void bowling(){
	System.out.println("Bowling first!");
	}
}


