import java.util.*;

class Node implements Comparable<Node> {
    int city; // Current city
    int days; // Number of days taken to reach this city

    // Constructor to initialize city and days
    public Node(int city, int days) {
        this.city = city;
        this.days = days;
    }

    // Comparator to sort nodes by days in ascending order
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.days, other.days);
    }
}

public class EmergencyTravelPlan {
    // method to calculate the minimum days required to travel from city 1 to city n
    private static int findMinDays(int numCities, List<List<Integer>> aerialRoutes) {
        // Array to store the minimum days required to reach each city
        int[] days = new int[numCities];
        Arrays.fill(days, Integer.MAX_VALUE); // Initialize all cities with maximum days
        days[0] = 0; // Starting city (city 1) requires 0 days

        // Priority queue for processing cities with the smallest number of days first
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0)); // Start from city 1 (index 0)

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); // Get the city with the smallest days

            // If the current city is the destination city, return the days
            if (currentNode.city == numCities - 1) {
                return currentNode.days;
            }

            // Explore all aerial connections from the current city
            for (int aerialCity : aerialRoutes.get(currentNode.city)) {
                // If a faster path is found to the connected city via an aerial route
                if (days[aerialCity] > currentNode.days) {
                    days[aerialCity] = currentNode.days; // Update the days for the connected city
                    queue.add(new Node(aerialCity, currentNode.days)); // Add the city to the queue
                }
            }

            // Explore road connections (can travel up to 6 cities in one day)
            int roadDays = currentNode.days + 1; // Traveling by road increases days by 1
            for (int i = 1; i <= 6; i++) {
                int nextCity = currentNode.city + i; // Calculate the next city
                if (nextCity < numCities && days[nextCity] > roadDays) {
                    days[nextCity] = roadDays; // Update the days for the next city
                    queue.add(new Node(nextCity, roadDays)); // Add the city to the queue
                }
            }
        }

        return -1; // Return -1 if there's no path to the destination city
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int testCases = sc.nextInt(); // Read the number of test cases

        for (int t = 0; t < testCases; t++) { // Process each test case
            System.out.print("Enter the number of cities: ");
            int numCities = sc.nextInt(); // Read the total number of cities

            // Initialize the adjacency list to store aerial routes
            List<List<Integer>> aerialRoutes = new ArrayList<>();
            for (int i = 0; i < numCities; i++) {
                aerialRoutes.add(new ArrayList<>()); // Create a list for each city
            }

            System.out.print("Enter the number of aerial routes: ");
            int numAerialRoutes = sc.nextInt(); // Read the number of aerial routes

            System.out.println("Enter the source and destination cities for aerial routes: ");
            for (int i = 0; i < numAerialRoutes; i++) {
                int source = sc.nextInt(); // Read the source city
                int destination = sc.nextInt(); // Read the destination city
                aerialRoutes.get(source).add(destination); // Add the route to the adjacency list
            }

            // Find the minimum days required to travel from city 1 to city n
            int minDays = findMinDays(numCities, aerialRoutes);
            System.out.println("Minimum days required to travel from city 1 to city " + numCities + ": " + minDays);
        }
    }
}
