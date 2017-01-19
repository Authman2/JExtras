package je.files;

import java.util.ArrayList;

import je.collections.Tuple;

public class Tester {

	public static void main(String[] args) {

		//ArrayList<Tuple> a = JSONParser.parse("{ name : 'adeola uthman', age : 19, languages : [english, french] }");
		ArrayList<Tuple> a = JSONParser.parseFrom("src/je/files/jsondata.txt");
		
		for(Tuple b : a) {
			if (b.get(1) instanceof Object[]) {
				System.out.print("("+b.get(0)+",[");
				for(Object j : (Object[])b.get(1)) {
					System.out.print(j.toString()+",");
				}
				System.out.print("])\n");
			} else {
				System.out.println(b.toString());
			}
		}
	}



}