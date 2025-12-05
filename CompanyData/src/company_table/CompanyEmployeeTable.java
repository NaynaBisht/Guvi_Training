package company_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class CompanyEmployeeTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, List<String>> company = new HashMap<>();
		
		company.put("Chubb", Arrays.asList("Amit", "Neha", "Ravi"));
        company.put("BlackRock", Arrays.asList("Rishita", "Karan", "Ananya"));
        company.put("ZS Associates", Arrays.asList("Suresh", "Priya", "Mehul"));
        company.put("Human Resocia", Arrays.asList("Vikas", "Disha", "Apoorva"));
        company.put("Apple", Arrays.asList("Isha", "Yashaswi", "Himadri"));
        company.put("Cognizant", Arrays.asList("Harshita", "Mansi", "Niharika"));
		
        
        for(Map.Entry<String, List<String>> entry : company.entrySet() ) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
        
//        check cognizant
        if (company.containsKey("Cognizant")) {
        	System.out.println("Cognizant found");
        	
            List<String> employees = company.get("Cognizant");
            
            // Check 'Ram'
            if (employees.contains("Ram")) {
                System.out.println("Ram is working in Cognizant");
            } else {

                System.out.println("Ram is not working in Cognizant");
            }
        }else {
        	 System.out.println("Cognizant not found");
             company.put("Cognizant", new ArrayList<>(Arrays.asList("Ram", "Swayam", "Kavya")));
             
             List<String> employees = company.get("Cognizant");
             if (employees.contains("Ram")) {
                 System.out.println("Ram is working in Cognizant");
             } else {

                 System.out.println("Ram is not working in Cognizant");
             }
        }
	}

}
