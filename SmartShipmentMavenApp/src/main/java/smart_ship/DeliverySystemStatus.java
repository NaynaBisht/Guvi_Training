package smart_ship;
import java.util.*;
import java.util.stream.Collectors;
public class DeliverySystemStatus implements DeliveryManager{
	private List<Agent> agents = new ArrayList<>();
    private Queue<PackageDetails> packages = new PriorityQueue<>(Comparator.comparingInt(PackageDetails::getPriority));

    // Add Agent
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    // Add Package
    public void addPackage(PackageDetails pack) {
        packages.offer(pack);
    }

    // Assign packages to available agents
    @Override
    public void assignPackages() throws AgentNotAvailableException{
        while (!packages.isEmpty()) {
            PackageDetails pack = packages.poll();

            // Find available agents in same city
            List<Agent> availableAgents = agents.stream()
                    .filter(a -> a.getCity().equalsIgnoreCase(pack.getDestinationCity()))
                    .sorted(Comparator.comparingInt(Agent::getAssignedPackages))
                    .collect(Collectors.toList());

            if (availableAgents.isEmpty()) {
                throw new AgentNotAvailableException(
                        "No available agent in " + pack.getDestinationCity() + " for Package " + pack.getPackageId());
            }

            // Assign to the agent with least number of packages
            Agent assigned = availableAgents.get(0);
            assigned.assignPackage();

            System.out.println("✅ Package " + pack.getPackageId() + " assigned to Agent " + assigned.getId() +
                    " in " + assigned.getCity());
        }
    }

    // Display all agents
    public void displayAgents() {
        System.out.println("\n Agent Details ");
        agents.forEach(Agent::displayDetails);
    }
}
