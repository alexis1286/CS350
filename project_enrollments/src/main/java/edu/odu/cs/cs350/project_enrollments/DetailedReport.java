package edu.odu.cs.cs350.project_enrollments;

import java.io.FileOutputStream;
import java.util.*;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.AxisTickMark;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.MarkerStyle;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFLineChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DetailedReport { 
	
	//
	
	public void createExcel(SortedMap<String, Course> hist, SortedMap<String, Course> curr, String path) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		 double[] dHist = new double[]{.1,.2,.5,.75,1.05};
		 double[] date1 = new double[]{30,35,50,52,54};
		 double[] dcurr = new double[] {0,.25,.5,0,0};
		 double[] date2 = new double[]{0,25,60,0,0};
		 double[] dProj = new double[]{0,0,.5,1,0};
		 double[] proj = new double[] {0,0,60,80,0};
		 
		 String headDate1 = "Season/Year";
		 String headDate2 = "Season/Year";
		
		for (String key : hist.keySet()) {
			XSSFSheet sheet = workbook.createSheet(hist.get(key).getCourseTitle());
			for (int i = 0; i < 6; i++) {

		            Row row = sheet.createRow((short) 0);
		            Cell cell = row.createCell((short) 0);
		            cell.setCellValue("dHistorical");
		            sheet.autoSizeColumn(0);

		            cell = row.createCell((short) 1);
		            cell.setCellValue(headDate1);
		            sheet.autoSizeColumn(1);

		            cell = row.createCell((short) 2);
		            cell.setCellValue("d current");
		            sheet.autoSizeColumn(2);

		            cell = row.createCell((short) 3);
		            cell.setCellValue(headDate2);
		            sheet.autoSizeColumn(3);

		            cell = row.createCell((short) 4);
		            cell.setCellValue("d projected");
		            sheet.autoSizeColumn(4);
		            
		            cell = row.createCell((short) 5);
		            cell.setCellValue("Projected");
		            sheet.autoSizeColumn(5);	            
		            
		            for (int j = 0; j < dHist.length; j++) {
		                row = sheet.createRow((short) j+1);
		                cell = row.createCell((short) 0);
		                cell.setCellValue(dHist[j]);
		                cell = row.createCell((short) 1);
		                cell.setCellValue(date1[j]);
		                cell = row.createCell((short) 2);
		                cell.setCellValue(dcurr[j]);
		                cell = row.createCell((short) 3);
		                cell.setCellValue(date2[j]);
		                cell = row.createCell((short) 4);
		                cell.setCellValue(dProj[j]);
		                cell = row.createCell((short) 5);
		                cell.setCellValue(proj[j]);
		            }
		            /*for (int j = 0; j < dcurr.length; j++) {
		                row = sheet.createRow((short) j+1);
		                cell = row.createCell((short) 2);
		                cell.setCellValue(dcurr[j]);
		                cell = row.createCell((short) 3);
		                cell.setCellValue(date2[j]);	                
		            }
		            for (int j = 0; j < dProj.length; j++) {
		                row = sheet.createRow((short) j+1);
		                cell = row.createCell((short) 4);
		                cell.setCellValue(dProj[j]);
		                cell = row.createCell((short) 5);
		                cell.setCellValue(proj[j]);
		            }*/

		            

		            XSSFDrawing drawing = sheet.createDrawingPatriarch();
		            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 8, 0, 15, 15);

		            XSSFChart chart = drawing.createChart(anchor);
		            chart.setTitleText("Enrollment Projection");
		            chart.setTitleOverlay(false);

		            XDDFChartLegend legend = chart.getOrAddLegend();
		            legend.setPosition(LegendPosition.RIGHT);

		            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
		            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
		            
		            bottomAxis.setMinimum(0);
		            bottomAxis.setMaximum(6);
		            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
		     

		            XDDFNumericalDataSource<Double> historical = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 5, 0, 0));

		            XDDFNumericalDataSource<Double> hSeason = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 5, 1, 1));

		            XDDFNumericalDataSource<Double> current = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 3, 2, 2));
		            
		            XDDFNumericalDataSource<Double> cSeason = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 3, 3, 3));
		            
		            XDDFNumericalDataSource<Double> projected = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 4, 4, 4));
		            
		            XDDFNumericalDataSource<Double> eProjected = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
		                    new CellRangeAddress(1, 4, 5, 5));
		            
		            XDDFLineChartData data = (XDDFLineChartData) chart.createData(ChartTypes.LINE, bottomAxis, leftAxis);

		            XDDFLineChartData.Series series1 = (XDDFLineChartData.Series) data.addSeries(historical, hSeason);
		            series1.setTitle("History", null);
		            series1.setSmooth(false);
		            series1.setMarkerStyle(MarkerStyle.NONE);

		            XDDFLineChartData.Series series2 = (XDDFLineChartData.Series) data.addSeries(current, cSeason);
		            series2.setTitle("Season/Year", null);
		            series2.setSmooth(false);
		            series2.setMarkerStyle(MarkerStyle.NONE);
		            
		            XDDFLineChartData.Series series3 = (XDDFLineChartData.Series) data.addSeries(projected, eProjected);
		            series3.setTitle("Projected", null);
		            series3.setSmooth(false);
		            series3.setMarkerStyle(MarkerStyle.NONE);
		           

		            chart.plot(data);
			}
						
		}
		try (FileOutputStream outputStream = new FileOutputStream(path)) {
	        workbook.write(outputStream);
	        workbook.close();
  
	} catch (IOException e) {
		//TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}