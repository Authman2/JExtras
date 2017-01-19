package je.files;

import java.util.ArrayList;

import je.collections.Tuple;

public class Tester {

	public static void main(String[] args) {

		ArrayList<Tuple> a = JSONParser.parse("{ name : 'adeola uthman', age : 19, languages : [english, french] }");
		JSONParser.parseFrom("src/je/files/jsondata.txt");
		
//		for(Tuple b : a) {
//			System.out.println(b.toString());
//		}
	}



}