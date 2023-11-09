package LabChartReports;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;

public class BarChart05 implements ExampleChart<CategoryChart> {

	public static void main(String[] args) {

		ExampleChart<CategoryChart> exampleChart = new BarChart05();
		CategoryChart chart = exampleChart.getChart();
		new SwingWrapper<CategoryChart>(chart).displayChart();

	}
	public CategoryChart getChart() {
		// Create Chart
		CategoryChart chart = new CategoryChartBuilder().width(600).height(800).title(getClass().getSimpleName())
				.xAxisTitle("Types of Values & Result Observing Styles").yAxisTitle("Total Resistor Measurements")
				.theme(ChartTheme.GGPlot2).build();
		// Customize Chart
		chart.getStyler().setPlotGridVerticalLinesVisible(false);
		chart.getStyler().setSeriesColors(new Color[] { Color.BLUE, Color.RED });
		chart.getStyler().setXAxisLabelRotation(45);
		// Series
		chart.addSeries("Total Resistor with Measured Resistor Values ",
				new ArrayList<>(Arrays.asList(new String[] { " by Multimeter", " by Calculator" })),
				new ArrayList<Number>(Arrays.asList(new Number[] { 0, CommercialResistorExperiment
						.getMainResistance(CommercialResistorExperiment.measuredValues) })));
		chart.addSeries("Total Resistor with Commercial Resistor Values",
				new ArrayList<>(Arrays.asList(new String[] { " by Multimeter", " by Calculator" })),
				new ArrayList<Number>(Arrays.asList(new Number[] {
						CommercialResistorExperiment.measuredTotalResistanceWithMultimeter, CommercialResistorExperiment
								.getMainResistance(CommercialResistorExperiment.commercialValues) })));
		return chart;
	}
	@Override
	public String getExampleChartName() {
		return getClass().getSimpleName() + " - GGPlot2 Theme";
	}
}
