package org.anveshgadde.loopgenerator;

public class VariantLoops {

	public static void main(String[] args) {
		String[] naamArr = { "anvesh", "kumar", "gadde", "kasturi", "ramana" };

		StringBuilder sbl = new StringBuilder();

		for (String naam : naamArr) {
			if (naam.equalsIgnoreCase("anvesh")) {
				sbl.append(naam);
				sbl.append(" success");
				sbl.append(System.getProperty("line.separator"));
			} else {
				sbl.append(naam);
				sbl.append(" failed");
				sbl.append(System.getProperty("line.separator"));
			}
		}
		
		System.out.println("End output: " +sbl.toString());
	}

}
