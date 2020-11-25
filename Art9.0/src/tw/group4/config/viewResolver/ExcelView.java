package tw.group4.config.viewResolver;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class ExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

//		HouseBean hBean = (HouseBean) model.get("houseBean");

		Sheet sheet = workbook.createSheet("sheet 1");
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		Row row = null;
		Cell cell = null;
		int rowCount = 0;
		int colCount = 0;
		
		// Create header cells
		row = sheet.createRow(rowCount++);

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("ID");

		cell = row.createCell(colCount++);
		cell.setCellStyle(style);
		cell.setCellValue("NAME");

		// Create data cells
		row = sheet.createRow(rowCount++);
		colCount = 0;
//		row.createCell(colCount++).setCellValue(hBean.getHouseid());
//		row.createCell(colCount++).setCellValue(hBean.getHousename());

		for (int i = 0; i < 2; i++)
			sheet.autoSizeColumn(i, true);

	}
}
