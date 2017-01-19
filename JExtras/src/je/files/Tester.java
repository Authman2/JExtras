package je.files;

import java.util.ArrayList;

import je.collections.Tuple;

public class Tester {

	public static void main(String[] args) {

		ArrayList<Tuple> a = JSONParser.parse("{ name : 'adeola uthman', age : 19, languages : [english, french] }");
		ArrayList<Tuple> b = JSONParser.parseFrom("src/je/files/jsondata.txt");
		
		for(Tuple t : a) {
			if (t.get(1) instanceof Object[]) {
				System.out.print("("+t.get(0)+",[");
				for(Object j : (Object[])t.get(1)) {
					System.out.print(j.toString()+",");
				}
				System.out.print("])\n");
			} else {
				System.out.println(t.toString());
			}
		}
		for(Tuple t : b) {
			if (t.get(1) instanceof Object[]) {
				System.out.print("("+t.get(0)+",[");
				for(Object j : (Object[])t.get(1)) {
					System.out.print(j.toString()+",");
				}
				System.out.print("])\n");
			} else {
				System.out.println(t.toString());
			}
		}
	}



}