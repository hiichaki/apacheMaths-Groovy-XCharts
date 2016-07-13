

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Chart extends JFrame implements ExampleChart<XYChart> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 460545923483594258L;
	private double[] xData;
	private double[] yData;
	private XYChart chart;
	private String name = "";

	
	public Chart(double[] vector, int from, int to, String str) {

		int n = Math.abs(from) + Math.abs(to) + 1;
		xData = new double[n];
		yData = new double[n];

		int j = 0;

		for (double x = from; x <= to; ++x) {

			double y =  (vector[0] + vector[1] * x);

			for (int i = 2; i < vector.length; ++i) {
				y += vector[i] * Math.pow(x, i);
			}

			yData[j] = y;
			xData[j] = x;
			++j;
		}
		
		// all program close instead
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		// new SwingWrapper(getChart()).displayChart();
		setBounds(950, 100, 500, 500);
		name = str;
		JPanel panelChart = new XChartPanel<XYChart>(getChart());
		setVisible(true);
		this.add(panelChart);
		this.validate();

	}
	
	@Override
	public XYChart getChart() {
		// Create Chart

		chart = new XYChartBuilder().width(500).height(500).title(getClass().getSimpleName()).xAxisTitle("X")
				.yAxisTitle("Y").build();

		// Customize Chart
		chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
		chart.getStyler().setAxisTitlesVisible(false);
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

		// Series
		chart.addSeries(name, xData, yData);

		return chart;
	}
}
