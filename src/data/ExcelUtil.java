package data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Question;
import model.Topic;

public final class ExcelUtil {

	public static List<Sheet> getSheets(String path) {
		List<Sheet> sheets = new ArrayList<>();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(inputStream);
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				sheets.add(workbook.getSheetAt(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheets;
	}
	
	public static Sheet getSheetByName(String path, String name) {
		Sheet sheet = null;
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(inputStream);
			
			sheet = workbook.getSheet(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public static Sheet getSheetByIndex(String path, int index) {
		Sheet sheet = null;
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(new File(path));
			Workbook workbook = new XSSFWorkbook(inputStream);
			
			sheet = workbook.getSheetAt(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sheet;
	}
	
	public static String getSheetName(Sheet sheet) {
		return sheet.getSheetName();
	}
	
	public static List<Question> readSheet(Sheet sheet) {
		List<Question> questions = new ArrayList<>();
		
		try {
			Iterator<Row> iterator = sheet.iterator();
			while(iterator.hasNext()) {
				Row row = iterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				
				cellIterator.next();
				
				Cell cell = cellIterator.next();
				String content = cell.getStringCellValue();
				
				List<String> answers = new ArrayList<>();
				cell = cellIterator.next();
				answers.add(cell.getStringCellValue());
				cell = cellIterator.next();
				answers.add(cell.getStringCellValue());
				cell = cellIterator.next();
				answers.add(cell.getStringCellValue());
				cell = cellIterator.next();
				answers.add(cell.getStringCellValue());
				
				cell = cellIterator.next();
				int result = (int) cell.getNumericCellValue();
				
				Question question = new Question(content, answers, result);
				questions.add(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}
}
