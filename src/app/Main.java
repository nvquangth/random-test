package app;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import data.Constants;
import data.ExcelUtil;
import data.TestUtil;
import data.TopicUtil;
import model.Question;

public class Main {
	
	public static void main(String[] args) {
		
//		TopicUtil.readTopicFromExcelToLocal();
		
		List<Sheet> sheets = ExcelUtil.getSheets(Constants.PATH_DATA);
		
		for (Sheet sheet: sheets) {
			List<Question> questions = ExcelUtil.readSheet(sheet);

			List<Question> test = TestUtil.genTest(questions, 6);
			
			printQuestions(test);
			
			ExcelUtil.write(Constants.PATH_OUTPUT,ExcelUtil.getSheetName(sheet), test);
			
			break;
		}
	}
	
	private static List<Question> fakeData() {
		List<Question> questions = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			List<String> answer = new ArrayList<>();
			answer.add("A");
			answer.add("B");
			answer.add("C");
			answer.add("D");
			questions.add(new Question("content", answer, 1));
		}
		
		return questions;
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
