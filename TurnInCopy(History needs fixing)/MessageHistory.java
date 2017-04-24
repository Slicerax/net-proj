import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class MessageHistory {
	public static void storeHistory(int sessionID, String ID_1, String ID_2, String message){
		
		if (new File(Paths.get(ID_1+ID_2+".txt").toString()).isFile() == true) {
			writeToFile(Paths.get(ID_1+ID_2+".txt").toString(), message, ID_1, sessionID);
		}
		else{
			writeToFile(Paths.get(ID_2+ID_1+".txt").toString(), message, ID_1, sessionID);
		}
	}

	public static void writeToFile(String path, String message, String ID_1, int sessionID){
		FileWriter fw;
		try {
			fw = new FileWriter(path,true);
		    fw.write(sessionID +" "+ ID_1 + " " + message + "\n");//appends the string to the file
		    fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getHistory(String reqID, String recID){
		String everything = "";
		if (new File(Paths.get(reqID+recID+".txt").toString()).isFile() == true) {
			everything = "HISTORY_RESP " + getHistoryString(Paths.get(reqID+recID+".txt").toString());
		}
		else{
			everything = "HISTORY_RESP " + getHistoryString(Paths.get(recID+reqID+".txt").toString());
		}
		return everything;
	}
	
	public static String getHistoryString(String path){
		String message ="";
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    message = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
