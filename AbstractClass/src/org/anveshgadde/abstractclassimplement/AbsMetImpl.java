package org.anveshgadde.abstractclassimplement;

abstract class MetDes {
	abstract void calc();
	MetDes(){
		System.out.println("MetDes constructor called!");
	}
}

public class AbsMetImpl extends MetDes {

	@Override
	void calc() {
		System.out.println("Calculated value!");
	}
	
	AbsMetImpl() throws CloneNotSupportedException{
		super.hashCode();
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		String name = "Anvesh";

		MetDes obj = new AbsMetImpl();
		
		if(obj instanceof AbsMetImpl){
			obj.calc();
			System.out.println("HashCode of string is: " +name.hashCode());
		}
	}

}
