package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Question;

public final class TestUtil {

	/**
	 * 
	 * @param input
	 * @param n: so luong cau hoi
	 * @return
	 */
	public static List<Question> genTest(List<Question> input, int n) {
		
		if (input.isEmpty() || input.size() <= n) {
			return input;
		}
		int TIME_OUT = 0;
		List<Question> questions = new ArrayList<>();
		
		Random random = new Random();
		
		while(questions.size() < n) {
			Question question = input.get(random.nextInt(input.size()));
			if (!questions.contains(question)) {
				questions.add(question);
			}
			TIME_OUT++;
			if (TIME_OUT > 1000) {
				break;
			}
		}
		
		if (questions.isEmpty()) {
			questions.addAll(input);
		}
		
		return questions;
	}
}
