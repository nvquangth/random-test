package model;

import java.util.List;

public class Question {

	private String mContent;
	private List<String> mAnswers;
	private int mResult;
	
	public Question() {
		
	}
	
	public Question(String mContent, List<String> mAnswers, int mResult) {
		super();
		this.mContent = mContent;
		this.mAnswers = mAnswers;
		this.mResult = mResult;
	}
	public String getmContent() {
		return mContent;
	}
	public void setContent(String content) {
		this.mContent = content;
	}
	public List<String> getmAnswers() {
		return mAnswers;
	}
	public void setAnswers(List<String> answers) {
		this.mAnswers = answers;
	}
	public int getResult() {
		return mResult;
	}
	public void setResult(int result) {
		this.mResult = result;
	}
}
