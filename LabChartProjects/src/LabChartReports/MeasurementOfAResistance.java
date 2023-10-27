package LabChartReports;

import java.awt.Font;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class MeasurementOfAResistance {

	/*
	 * Measurement of a single resistance element Using the digital multimeter,
	 * measure the current passing through a 1 kohm and a 550 ohm resistances by
	 * changing the applied voltage.
	 */

	// Create Chart
	public static XYChart chart = new XYChartBuilder().title("Measurement of a single resistance element")
			.xAxisTitle("Current(mA)").yAxisTitle("Voltage(V)").height(500).width(800).build();
	public static double[] Vs = new double[] { 0.02, 0.50, 1.00, 1.51, 2.01, 2.49, 3.00 };
	public static double[] currentRead = new double[] { 0.02, 0.50, 1.00, 1.50, 2.01, 2.50, 3.01 };

	public static void main(String[] args) throws Exception {
		// for the 1kOhm

		double xFirst = -0.5, xLast = 3.5;
		double yFirst = -1.0, yLast = 4.0;

		resistanceList(Vs, currentRead, Vs.length);
		MeasurementOfTwoResistance.getMainResistance(Vs, currentRead, Vs.length);

		// DECLARE THE RANGE OF GRAPH
		chart.getStyler().setYAxisMin(yFirst).setYAxisMax(yLast);
		chart.getStyler().setXAxisMin(xFirst).setXAxisMax(xLast);

		// SET THE STYLE OF THE TITLES
		chart.getStyler().setAxisTickLabelsFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
		chart.getStyler().setAxisTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		chart.getStyler().getSeriesMarkers();

		// DESIGN THE LINE
		XYSeries series = chart.addSeries("RESISTOR", currentRead, Vs);
		series.setLineColor(XChartSeriesColors.RED);
		series.setLineStyle(SeriesLines.SOLID);
		series.setMarkerColor(XChartSeriesColors.RED);
		series.setMarker(SeriesMarkers.CIRCLE);

		chart.getStyler().setAxisTitlesVisible(true);
		chart.getStyler().setPlotGridLinesVisible(true);
		chart.getStyler().getPlotGridLinesStroke().getDashPhase();
		chart.getStyler().setAxisTickPadding(2);

		// Show it
		new SwingWrapper(chart).displayChart();
		// Save it
		// BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

		// or save it in high-res
		// BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI",
		// BitmapFormat.PNG, 300);
	}

	public static void resistanceList(double[] vs, double[] current, int length) {
		System.out.print("Calculated resistances are: \n{");
		double[] resistance = new double[length];
		double totalResistance = 0;
		for (int i = 0; i < resistance.length; i++)
			resistance[i] = vs[i] / (current[i] / 1000);
		for (int i = 0; i < resistance.length; i++) {
			totalResistance += resistance[i];
			System.out.printf("%.2f, ", resistance[i]);
		}
		double mainResistance = (totalResistance / length);
		System.out.printf("} ohms\nMean resistance is: %.3f ohm\n", mainResistance);
	}

}
