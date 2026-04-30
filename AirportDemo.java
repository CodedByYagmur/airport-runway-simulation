package Airport;

public class AirportDemo {
	public static void main(String[] args) {		//Main class
		RunwayManager tower = new RunwayManager();
        double currentTime = 1.0; // Starting the simulation at time step 1

        System.out.println("=================================================");
        System.out.println("     AIRPORT RUNWAY SIMULATION INITIALIZED       ");
        System.out.println("=================================================");

        // ---------------------------------------------------------
        // EXERCISE 1.1 & 1.2: Single Arrival & Identity Check
        // ---------------------------------------------------------
        System.out.println("\n>>> TEST 1: Single Arrival");

        tower.addPlaneToLanding(new Plane(101, currentTime)); 
        tower.processTimeStep(currentTime);
        currentTime++; // Advance time step

        // ---------------------------------------------------------
        // EXERCISE 2.1: The Priority Rule
        // Goal: Verify the Landing plane goes first.
        // ---------------------------------------------------------
        System.out.println("\n>>> TEST 2: The Priority Rule");

        tower.addPlaneToTakeoff(new Plane(201, currentTime));
        tower.addPlaneToTakeoff(new Plane(202, currentTime));
        tower.addPlaneToTakeoff(new Plane(203, currentTime));
        tower.addPlaneToLanding(new Plane(999, currentTime)); // 999 will go first according to the plane take off rule 

        // Run 4 time steps to clear all 4 planes
        for (int i = 0; i < 4; i++) {
            tower.processTimeStep(currentTime);
            currentTime++;
        }

        // ---------------------------------------------------------
        // EXERCISE 2.2: The "Clear the Air" Test
        // Goal: Verify all landings finish before take offs start.
        // ---------------------------------------------------------
        System.out.println("\n>>> TEST 3: Clear the Air");
     
        tower.addPlaneToTakeoff(new Plane(301, currentTime));
        tower.addPlaneToTakeoff(new Plane(302, currentTime));
        tower.addPlaneToLanding(new Plane(888, currentTime));
        tower.addPlaneToLanding(new Plane(777, currentTime));

        // Run 4 steps[cite: 1]
        for (int i = 0; i < 4; i++) {
            tower.processTimeStep(currentTime);
            currentTime++;
        }

        // ---------------------------------------------------------
        // EXERCISE 3.1: Statistics[cite: 1]
        // Goal: Calculate average wait time for all planes.[cite: 1]
        // ---------------------------------------------------------
        System.out.println("\n=================================================");
        System.out.println("                 FINAL STATISTICS                ");
        System.out.println("=================================================");
        System.out.println("Total Planes Landed: " + tower.countLanding);
        System.out.println("Total Planes Departed: " + tower.countTakeOff);
        
        int totalPlanesProcessed = tower.countLanding + tower.countTakeOff;
        if (totalPlanesProcessed > 0) {
            double averageWaitTime = tower.totalWaitTime / totalPlanesProcessed;
            System.out.printf("Average Wait Time: %.2f time steps\n", averageWaitTime);
        } else {
            System.out.println("No planes processed.");
        }
    
		
		
	}
}
