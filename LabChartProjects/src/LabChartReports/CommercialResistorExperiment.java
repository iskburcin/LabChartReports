package LabChartReports;

import java.awt.Font;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class CommercialResistorExperiment {

	public static double[] commercialValues = new double[] { 560, 1 * Math.pow(10, 3), 
			(6.7) * Math.pow(10, 3)};
	public static double[] measuredValues = new double[] { 548, 991, 6.67 * Math.pow(10, 3) };
	public static double measuredTotalResistanceWithMultimeter = 335;
	public static double[] resistor = new double[] { 1.0, 2.0, 3.0 };

	public static void main(String[] args) {

		XYChart chart = new XYChartBuilder().title("Individual Resistor Values").xAxisTitle("Resistors")
				.yAxisTitle("Resistance Values (ohms)").height(1000).width(1100).build();

		// for the 1kOhm

		double xFirst = 1, xLast = 3;
		double yFirst = 0, yLast = 7000;

		// DECLARE THE RANGE OF GRAPH
		chart.getStyler().setYAxisMin(yFirst).setYAxisMax(yLast);
		chart.getStyler().setXAxisMin(xFirst).setXAxisMax(xLast);

		// SET THE STYLE OF THE TITLES
		chart.getStyler().setAxisTickLabelsFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		chart.getStyler().setAxisTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().getSeriesMarkers();

		// DESIGN THE LINE
		XYSeries series = chart.addSeries("Measured Values", resistor, measuredValues);
		series.setLineColor(XChartSeriesColors.BLUE);
		series.setLineStyle(SeriesLines.SOLID);
		series.setMarkerColor(XChartSeriesColors.BLUE);
		series.setMarker(SeriesMarkers.CIRCLE);

		XYSeries seriesx = chart.addSeries("Commercial Values", resistor, commercialValues);
		seriesx.setLineColor(XChartSeriesColors.RED);
		seriesx.setLineStyle(SeriesLines.SOLID);
		seriesx.setMarkerColor(XChartSeriesColors.RED);
		seriesx.setMarker(SeriesMarkers.CIRCLE);

		chart.getStyler().setAxisTitlesVisible(true);
		chart.getStyler().setPlotGridLinesVisible(true);
		chart.getStyler().getPlotGridLinesStroke().getDashPhase();
		chart.getStyler().setAxisTickPadding(9);

		// Show it
		// 1. Before parallel connection of resistors, measure the individual resistance
		// values for commercially given,
		System.out.print("Commercial Resistance Values:{R1, R2, R3}:");
		printList(commercialValues);
		// 2. Connect 3 different resistors in a parallel way. Measure the total
		// resistance then record it
		System.out.printf("Total Resistance by Multimeter: %.2f", measuredTotalResistanceWithMultimeter);
		// 3. Calculate the total resistance for the composed circuit in a theoretical
		// way. Compare theory with experiment.
		System.out.printf("\nTotal Resistance by Calculator: %.3f", getMainResistance(commercialValues));
		System.out.println("\n--------------------------------------------------");
		System.out.print("Measured Resistance Values:{R1, R2, R3}:");
		printList(measuredValues);
		// Rt is the equivalence Resistance of given circuit
		System.out.printf("Total Resistance by Calculator: %.2f", getMainResistance(measuredValues));
		System.out.printf(
				"\nThere is %.2f ohm difference between commercially given and "
						+ "measured values \nwhen we observed the total result by calculating",
				(getMainResistance(commercialValues) - getMainResistance(measuredValues)));

		new SwingWrapper(chart).displayChart();
		// --------------------------------------------
		ExampleChart<CategoryChart> exampleChart = new BarChart05();
		CategoryChart chart2 = exampleChart.getChart();
		new SwingWrapper<CategoryChart>(chart2).displayChart();
	}

	public static void printList(double[] list) {
		System.out.print("{");
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + ", ");
		System.out.println("}");

	}

	public static double getMainResistance(double[] resistor) {
		double totalResistance = 0;
		for (int i = 0; i < resistor.length; i++)
			totalResistance += (1 / resistor[i]);
		double mainResistance = (1 / totalResistance);
		return mainResistance;
	}

}
