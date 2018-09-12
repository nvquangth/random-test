package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public final class FIleUtil {

	public static List<String> getListName(String path) {
		ArrayList<String> names = new ArrayList<>();
		
		File file = new File(path);
		File [] files = file.listFiles();
		
		for(File f: files) {
			names.add(f.getName());
		}
		
		return names;
	}
	
	public static List<String> getListNameAbsolute(String path) {
		ArrayList<String> names = new ArrayList<>();
		
		File file = new File(path);
		File [] files = file.listFiles();
		
		for(File f: files) {
			names.add(f.getAbsolutePath());
		}
		
		return names;
	}
	
	public static String readFile(String path) throws Exception {
		File file = new File(path);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
		      
		StringBuilder sb = new StringBuilder();
		
		String str;
		      
		while ((str = in.readLine()) != null) {
		    sb.append(str);
		    sb.append("\n");
		}
		in.close();
		return sb.toString();
	}
	
	public static void writeFile(String json, String path) throws Exception {
		
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
		writer.write(json);

		writer.close();
	}
}
