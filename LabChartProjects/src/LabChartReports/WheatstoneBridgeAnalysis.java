package LabChartReports;  
public class WheatstoneBridgeAnalysis {
	public static void main(String[] args) {

		double potantiometerValue = 0;// up to 10kohm
		double[] resistorCommercialValues = new double[] { 1 * Math.pow(10, 3), potantiometerValue,
				1.5 * Math.pow(10, 3), 6.7 * Math.pow(10, 3) };
		double[] resistorMeasuredValues = new double[] { 991, potantiometerValue, 1470, 6670 };
		// On the paper
		System.out.println("Commercial Values of Resistances: ");
		printResistances(resistorCommercialValues);
		System.out.printf("Theoretically R2, potantiometer is equal to: %.2f Ohms",
				theoryOfWheatstoneBridge(resistorCommercialValues));
		System.out.print("\n------------------------------------------------------");

		// From experiment
		System.out.print("\nMeasured Values of Resistances: \n");
		printResistances(resistorMeasuredValues);
		System.out.printf("Experiment shows R2, potantiometer is equal to: %.2f Ohms",
				theoryOfWheatstoneBridge(resistorMeasuredValues));
		System.out.print("\n------------------------------------------------------");
		System.out.printf("\nThere is %.2f ohm difference between commertially given and measured values.",
				(theoryOfWheatstoneBridge(resistorMeasuredValues)
						- theoryOfWheatstoneBridge(resistorCommercialValues)));
	}
	static void printResistances(double[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print("R" + (i + 1) + ": " + list[i] + ", ");
		}
		System.out.println();
	}

	static double theoryOfWheatstoneBridge(double[] resistors) {
		double potantiometer = 0;
		for (int i = 0; i < resistors.length; i++)
			if (resistors[i] == 0)
				potantiometer = resistors[i];
		potantiometer = resistors[0] * resistors[3] / resistors[2];
		return potantiometer;
	}
}
