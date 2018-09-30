package data;

public final class AppUtil {

	public static void printProgress(int total, int progress, String title) {
		System.out.println(title + " processing: " + (int)(((float) progress / total) * 100) + " %");
	}
	
	public static void printProgress(String title) {
		System.out.println(title + " processing: 100 %");
	}
}
