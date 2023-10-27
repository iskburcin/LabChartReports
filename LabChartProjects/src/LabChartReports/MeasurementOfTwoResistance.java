package LabChartReports;

import java.awt.Font;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class MeasurementOfTwoResistance {
	
	/* SERIAL CONNECTION OF TWO RESISTANCES
	 * 
	 * Connect R1= 1kohm and R2 = 560 ohm resistances in a serial way, 
	 * 1. Measure the total voltage (V1) for total resistance, 
	 * 2. Measure the voltage (V2) for R2,
	 * 3. Measure the current (i) passing through the circuit, 
	 * 4. Draw a graph for V1 vs current, 
	 * 5. Draw a graph for V2 vs Current, 
	 * 6. Find the mean resistance value from the graphs for Rt and R2,
	 * 7. Theoretically calculate V2 by using V1,
	 * R2, and Rt values obtained from experiment. )
	 * V1 = (}; V2 = ();
	 * i= {);
	 * 11=Thread[{i, V1}]; 12= Thread[{i, V2}];
	 */
	
	public static void main(String[] args) {
		double[] V1 = new double[] { 1.04, 1.47, 1.95, 2.55, 2.98 };
		double[] V2 = new double[] { 0.34, 0.48, 0.65, 0.85, 1.00 };
		double[] i = new double[] { 0.63, 0.88, 1.18, 1.55, 1.82 };
		// If they are serial, resistances are going to have same current
		System.out.print("Mean resistance for R1 is: ");
		System.out.printf("%.3f ohm\n", getMainResistance(V1, i, V1.length));

		System.out.print("Mean resistance for R2 is: ");
		System.out.printf("%.3f ohm", getMainResistance(V2, i, V2.length));

		double xFirst = 0.5, xLast = 2;
		double yFirst = 0, yLast = 3.5;

		XYChart chart = new XYChartBuilder().title("Measurement of a single resistance element")
				.xAxisTitle("Current(mA)").yAxisTitle("Voltage(V)").height(500).width(800).build();

		// IMPORT THE PREVIOUS RESISTOR INFORMATION
		XYSeries redSeries = chart.addSeries("red RESISTOR", i, V1);
		redSeries.setLineColor(XChartSeriesColors.RED);
		redSeries.setLineStyle(SeriesLines.SOLID);
		redSeries.setMarkerColor(XChartSeriesColors.RED);
		redSeries.setMarker(SeriesMarkers.CIRCLE);

		// -----------------------------------

		// DECLARE THE RANGE OF GRAPH
		chart.getStyler().setYAxisMin(yFirst).setYAxisMax(yLast);
		chart.getStyler().setXAxisMin(xFirst).setXAxisMax(xLast);

		// SET THE STYLE OF THE TITLES
		chart.getStyler().setAxisTickLabelsFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		chart.getStyler().setAxisTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().getSeriesMarkers();

		// DESIGN THE LINE
		XYSeries series = chart.addSeries("BLUE RESISTOR", i, V2);
		series.setLineColor(XChartSeriesColors.BLUE);
		series.setLineStyle(SeriesLines.DASH_DASH);
		series.setLineWidth(5);
		series.setMarkerColor(XChartSeriesColors.BLUE);
		series.setMarker(SeriesMarkers.SQUARE);

		// Show it
		new SwingWrapper(chart).displayChart();
		double R1 = getMainResistance(V1, i, V1.length);
		double R2 = getMainResistance(V2, i, V2.length);
		System.out.printf("\n**QUESTION**\n*Using mean R2=%.3f and RT%.2f and V1 =2V, Calculate "
				+ "V2 theoreticcally \nV2 is: %.5f Volt", R2, R1, getVoltageOfResistance(2, R2, R1));
	}

	public static double getMainResistance(double[] vs, double[] current, int length) {
		double[] resistance = new double[length];
		double totalResistance = 0;
		for (int i = 0; i < resistance.length; i++) {
			resistance[i] = vs[i] / (current[i] / 1000);
			totalResistance += resistance[i];
		}
		double mainResistance = (totalResistance / length);
		return mainResistance;
	}

	public static double getVoltageOfResistance(double v, double r1, double rTotal) {
		double v_specific = v * r1 / rTotal;
		return v_specific;
	}

}
