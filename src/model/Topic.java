package model;

import com.google.gson.annotations.SerializedName;

public class Topic {

	@SerializedName("id")
	private int mId;
	@SerializedName("name")
	private String mName;
	@SerializedName("total_question")
	private int mTotalQuestion;
	
	public Topic() {
		
	}

	public Topic(int id, String name) {
		super();
		mId = id;
		mName = name;
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public int getTotalQuestion() {
		return mTotalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		mTotalQuestion = totalQuestion;
	}
}
