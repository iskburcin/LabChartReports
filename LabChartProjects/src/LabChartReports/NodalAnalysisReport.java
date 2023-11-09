package LabChartReports;

public class NodalAnalysisReport {
		
	public static void main(String[] args) {
		double[] resistors = new double[] { 797, 329, 546, 1479, 6680, 971 };
		double[] nodeVoltages = new double[] { 1.892, 1.133, 0.224, 0.066 };

		// Calculate the total Resistor by setting the circuit up
		double totalResistance = getTotalResistance("Serial", resistors[0], resistors[1]);
		System.out.printf("1. Step : %.3f\n", totalResistance);

		totalResistance = getTotalResistance("Parallel", resistors[2], totalResistance);
		System.out.printf("2. Step : %.3f\n", totalResistance);

		totalResistance = getTotalResistance("Serial", resistors[3], totalResistance);
		System.out.printf("3. Step : %.3f\n", totalResistance);

		totalResistance = getTotalResistance("Parallel", resistors[4], totalResistance);
		System.out.printf("4. Step : %.3f\n", totalResistance);

		totalResistance = getTotalResistance("Serial", resistors[5], totalResistance);
		System.out.printf("Equavalence Resistance: %.3f kohm\n", (totalResistance * Math.pow(10, -3)));
		
		//find the each current on each wire
		double i5 = getCurrent(nodeVoltages[2], 0, resistors[2]);
		System.out.printf("i5: %.3f mA\n", i5);
		double i4 = getCurrent(nodeVoltages[2], nodeVoltages[3], resistors[0]);
		// i4 = getCurrent(nodeVoltages[3],0,resistors[1]);
		System.out.printf("i4: %.3f mA\n", i4);
		double i2 = getCurrent(nodeVoltages[1], nodeVoltages[2], resistors[3]);
		// i2 = i5 + i4;
		System.out.printf("i2: %.3f mA\n", i2);
		double i3 = getCurrent(nodeVoltages[1], 0, resistors[4]);
		System.out.printf("i3: %.3f mA\n", i3);
		double i1 = getCurrent(nodeVoltages[0], nodeVoltages[1], resistors[5]);
		// i1 = i2 + i3;
		System.out.printf("i1: %.3f mA\n", i1);
		System.out.printf("Main Current: %.3f mA\nTotal Current(V/Re): %.3f mA", (i1),
				getCurrent(nodeVoltages[0], 0, totalResistance));

	}

	static double getTotalResistance(String s, double r1, double r2) {
		double r = 0;
		switch (s) {
		case "Serial":
			r = (r1 + r2);
			break;
		case "Parallel":
			r = 1 / ((1 / r1) + (1 / r2));
			break;
		default:
			System.out.println("Invalid input!");
		}
		return r;
	}

	static double getCurrent(double v1, double v2, double r) {
		double i = (v1 - v2) / r;
		return i * 10000;
	}
}
