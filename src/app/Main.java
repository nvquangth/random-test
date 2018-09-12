package app;

import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import data.Constants;
import data.ExcelUtil;
import data.TestUtil;
import data.TopicUtil;
import model.Question;

public class Main {
	
	public static void main(String[] args) {
		
		TopicUtil.readTopicFromExcelToLocal();
		
//		List<Sheet> sheets = ExcelUtil.getSheets(PATH);
//		
//		for (Sheet sheet: sheets) {
//			List<Question> questions = ExcelUtil.readSheet(sheet);
//
//			List<Question> test = TestUtil.genTest(questions, 5);
//			
//			printQuestions(test);
//			
//			break;
//		}
	}
	
	private static void printQuestion(Question q) {
		System.out.println(q.getmContent());
		for (String s: q.getmAnswers()) {
			System.out.println(s);
		}
	}
	
	private static void printQuestions(List<Question> questions) {
		for (Question question: questions) {
			printQuestion(question);
			System.out.println("\n");
		}
	}
}
