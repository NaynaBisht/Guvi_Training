package smart_ship;

import java.util.*;

public class SmartShipment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		DeliverySystemStatus system = new DeliverySystemStatus();
		
		System.out.print("Add the number of agents : ");
		int agentsNum = sc.nextInt();
		
		for(int i=0; i<agentsNum; i++ ) {
			System.out.println("Enter details of Agent : ");
			
			System.out.println("ID : ");
			int id = sc.nextInt();
			
			System.out.println("Name : ");
			String name = sc.nextLine();
			
			System.out.println("city : ");
			String city = sc.nextLine();
			
			system.addAgent(new Agent(id, name, city));
		}
		
		System.out.print("\nEnter number of packages: ");
        int numPackages = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPackages; i++) {
            System.out.println("\nEnter details for Package " + (i + 1));
            System.out.println("Package ID: ");
            int pid = sc.nextInt();
            sc.nextLine();
            System.out.println("Destination City: ");
            String dest = sc.nextLine();
            System.out.println("Priority (1=High, 2=Medium, 3=Low): ");
            int priority = sc.nextInt();
            system.addPackage(new PackageDetails(pid, dest, priority));
        }

        
        try {
            System.out.println("\nAssigning packages...");
            system.assignPackages();
        } catch (AgentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // --- Display Results ---
        system.displayAgents();
        sc.close();
	}

}
