package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

	private static final int TIME_DELAY = 1000;
	
	/**
	 * Get danh sách các sheet
	 * @param path
	 * @return
	 */
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
	
	/**
	 * Get sheet by name
	 * @param path
	 * @param name
	 * @return
	 */
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
	
	/**
	 * Get sheet by index (start = 0)
	 * @param path
	 * @param index
	 * @return
	 */
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
	
	/**
	 * Get tên sheet
	 * @param sheet
	 * @return
	 */
	public static String getSheetName(Sheet sheet) {
		return sheet.getSheetName();
	}
	
	/**
	 * Get danh sách câu hỏi trong 1 sheet
	 */
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
				Thread.sleep(TIME_DELAY);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return questions;
	}
	
	public static void write(String path, String nameSheet, List<Question> questions) {
		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet(nameSheet);
			for (int i = 0; i < questions.size(); i++) {
				AppUtil.printProgress(questions.size(), i, "Write test");
				Question question = questions.get(i);
				Row row = sheet.createRow(i);
				row.createCell(0).setCellValue(i + 1);
				row.createCell(1).setCellValue(question.getmContent());
				for (int j = 0; j < question.getmAnswers().size(); j ++) {
					row.createCell(2 + j).setCellValue(question.getmAnswers().get(j));
				}
				row.createCell(questions.get(i).getmAnswers().size() + 2).setCellValue(questions.get(i).getResult());
				Thread.sleep(TIME_DELAY);
			}
			
			for(int i = 0; i < 7; i++) {
	            sheet.autoSizeColumn(i);
	        }
			
			FileOutputStream fileOut = new FileOutputStream(path);
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();
	        
	        AppUtil.printProgress("Write test");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
