class Bank {
	int interestRate() {
		return 0;
	}
}

class SBI extends Bank{

	int interestRate() {
		return 9;
	}
}

class ICICI extends Bank {
	int interestRate() {
		return 15;
	}
}

class RBC extends Bank {
	int interestRate() {
		return 23;
	}
}

public class BanksRate {

	public static void main(String[] args) {
		Bank bR, bR2, bR3;
		bR = new SBI();
		bR2 = new ICICI();
		bR3 = new RBC();
		
		System.out.println("Bank interest rate of SBI: " +bR.interestRate()+" %");
		System.out.println("Bank interest rate of ICICI: " +bR2.interestRate()+" %");
		System.out.println("Bank interest rate of RBC: " +bR3.interestRate()+" %");
	}

}
