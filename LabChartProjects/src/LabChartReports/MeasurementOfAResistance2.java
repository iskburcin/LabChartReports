package LabChartReports;

import java.awt.Font;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class MeasurementOfAResistance2 {

	public static double[] Vs = new double[] { 0.02, 0.50, 1.00, 1.50, 1.99, 2.50, 3.00 };
	public static double[] currentRead = new double[] { 0.04, 0.91, 1.81, 2.73, 3.61, 4.53, 5.44 };

	public static void main(String[] args) {
		// for the 560 Ohm

		double xFirst = -1.0, xLast = 6.0;
		double yFirst = -1.0, yLast = 4.0;

		MeasurementOfAResistance.resistanceList(Vs, currentRead, Vs.length);
		MeasurementOfTwoResistance.getMainResistance(Vs, currentRead, Vs.length);

		// Create Chart

		XYChart chart = new XYChartBuilder().title("Measurement of a single resistance element")
				.xAxisTitle("Current(mA)").yAxisTitle("Voltage(V)").height(500).width(800).build();

		// IMPORT THE PREVIOUS RESISTOR INFORMATION
		XYSeries redSeries = chart.addSeries("red RESISTOR", MeasurementOfAResistance.currentRead,
				MeasurementOfAResistance.Vs);
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
		XYSeries series = chart.addSeries("BLUE RESISTOR", currentRead, Vs);
		series.setLineColor(XChartSeriesColors.BLUE);
		series.setLineStyle(SeriesLines.DASH_DASH);
		series.setLineWidth(5);
		series.setMarkerColor(XChartSeriesColors.BLUE);
		series.setMarker(SeriesMarkers.SQUARE);

		// Show it
		new SwingWrapper(chart).displayChart();
	}
}
