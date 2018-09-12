package data;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Topic;

public final class TopicUtil {
	
	public static void readTopicFromExcelToLocal() {
		List<Topic> topics = getTopicsFromExcel();
		writeTopic(topics);
	}

	public static List<Topic> getTopicsFromLocal() {
		List<Topic> topics = new ArrayList<>();
		try {
			topics = new Gson().fromJson(FIleUtil.readFile(Constants.PATH_TOPIC), new TypeToken<List<Topic>>(){}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topics;
	}
	
	public static void writeTopic(List<Topic> topics) {
		String s = new Gson().toJson(topics);
		try {
			FIleUtil.writeFile(s, Constants.PATH_TOPIC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Topic> getTopicsFromExcel() {
		List<Topic> topics = new ArrayList<>();
		
		List<Sheet> sheets = ExcelUtil.getSheets(Constants.PATH_DATA);
		
		for (int i = 0; i < sheets.size(); i++) {
			Topic topic = new Topic();
			topic.setId(i);
			topic.setName(ExcelUtil.getSheetName(sheets.get(i)));
			topic.setTotalQuestion(ExcelUtil.readSheet(sheets.get(i)).size());
			topics.add(topic);
		}
		
		return topics;
	}
}
