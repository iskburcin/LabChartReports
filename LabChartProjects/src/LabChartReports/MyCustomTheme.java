package LabChartReports;
 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.lines.XChartSeriesLines;
import org.knowm.xchart.style.markers.Marker;
import org.knowm.xchart.style.markers.XChartSeriesMarkers;
import org.knowm.xchart.style.theme.AbstractBaseTheme;

public class MyCustomTheme {
	// Chart Style ///////////////////////////////

	  public Font getBaseFont() {

	    return new Font(Font.SERIF, Font.PLAIN, 10);
	  }

	  
	  public Color getChartBackgroundColor() {

	    return ChartColor.DARK_GREY.getColor();
	  }

	  
	  public Color getChartFontColor() {

	    return ChartColor.DARK_GREY.getColor();
	  }

	  
	  public int getChartPadding() {

	    return 12;
	  }

	  
	  public Color[] getSeriesColors() {

	    return new MyCustomSeriesColors().getSeriesColors();
	  }

	  
	  public Marker[] getSeriesMarkers() {

	    return new XChartSeriesMarkers().getSeriesMarkers();
	  }

	  
	  public BasicStroke[] getSeriesLines() {

	    return new XChartSeriesLines().getSeriesLines();
	  }

	  // Chart Title ///////////////////////////////

	  
	  public Font getChartTitleFont() {

	    return getBaseFont().deriveFont(Font.BOLD).deriveFont(18f);
	  }

	  
	  public boolean isChartTitleBoxVisible() {

	    return false;
	  }

	  
	  public Color getChartTitleBoxBackgroundColor() {

	    return ChartColor.GREY.getColor();
	  }

	  
	  public Color getChartTitleBoxBorderColor() {

	    return ChartColor.GREY.getColor();
	  }

	  // Chart Legend ///////////////////////////////

	  // Chart Axes ///////////////////////////////

	  
	  public BasicStroke getAxisTickMarksStroke() {

	    return new BasicStroke(
	        1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float[] {3.0f, 0.0f}, 0.0f);
	  }

	  // Chart Plot Area ///////////////////////////////

	  
	  public boolean isPlotTicksMarksVisible() {

	    return false;
	  }

	  
	  public BasicStroke getPlotGridLinesStroke() {

	    return new BasicStroke(
	        0.25f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10.0f, new float[] {3.0f, 3.0f}, 0.0f);
	  }

	  // Category Charts ///////////////////////////////

	  // Pie Charts ///////////////////////////////

	  // Line, Scatter, Area Charts ///////////////////////////////

	  
	  public int getMarkerSize() {

	    return 16;
	  }

	  // Error Bars ///////////////////////////////

	  // Annotations ///////////////////////////////

}
