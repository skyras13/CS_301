import java.util.Scanner;

public class BinaryMain {

	private static int numRecords = 0;
	private static int numQueries = 0;
	
	public static void main(String[] args) {
		
		
		//allowing for standard input
		Scanner s = new Scanner(System.in);
		System.out.print("Please Provide the Required Info \n");
		
		//parsing the number of employee records
		numRecords = Integer.parseInt(s.nextLine());
		Employee[] employees = new Employee[numRecords];
		
		
		//parsing all of the input for the different employees.
		for(int i = 0; i < numRecords; i++) {
			String slot = s.nextLine();
			String[] info = slot.split("\\|",0);
			String name = info[0];
			int id = Integer.parseInt(info[1]);
			int age = Integer.parseInt(info[2]);
			String job = info[3];
			String start = info[4];
			Employee next = new Employee(name,id,age,job,start); 
			employees[i] = next;
			//System.out.println(employees[i].iD);
		}
		
		numQueries = Integer.parseInt(s.nextLine());
		//System.out.println(""+numQueries);
		int[] checks = new int[numQueries];
		double[] comps = new double[numQueries];
		
		//parsing the queries
		for (int i = 0; i < numQueries; i++) {
			int next = s.nextInt();
			checks[i] = next;
			//System.out.println(checks[i]);
		}
		int queryIn = 0;	
		
		//my formula for Binary Search
		for(int c:checks) {
			double checkNum = 0;
			int answer = 0;
			int low = 0;
			int high = numRecords;
			while(low<high) {
				int mid = ((low+high)/2);
				if(c <= employees[mid].iD) {
					high = mid;
					checkNum++;
				}else {
					low = mid + 1;
					checkNum++;
				}
			}
			answer = high;
			comps[queryIn] = checkNum;
//			System.out.println("Found: Name: "+employees[answer].name+", Age: "+employees[answer].age+
//					", Job: "+employees[answer].job+", Hired: "+employees[answer].startYear+"\n"
//					+ "at index "+answer+" after "+Math.round(checkNum)+" comparisons.");
			queryIn++;
		}
		
		//finding the average number of comparisons
		double sum = 0;
		for(double num:comps) {
			sum = sum+num;
		}
		double average = (sum/numQueries);
		
		//Printing out the average number of comparisons
		System.out.println("Done! Average number of work per query: "+average+" comparisons");
	}
}

