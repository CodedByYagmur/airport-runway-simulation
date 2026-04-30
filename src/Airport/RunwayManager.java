package Airport;

public class RunwayManager {

    int countLanding = 0;
    int countTakeOff = 0;
    double totalWaitTime = 0.0;

    AirportInterface<Plane> landingQ = new AirportImplementation<>();
    AirportInterface<Plane> takeoffQ = new AirportImplementation<>();
    
    public int reportTime(double currentTime, double arrivalTime) {
        double waitTime = currentTime - arrivalTime;
        this.totalWaitTime += waitTime; 
        return (int) waitTime;
    }
    
    private void landPlane(double currentTime) {
        Plane landed = landingQ.dequeue();
        countLanding++;
        int wait = reportTime(currentTime, landed.arrivalTime);
        System.out.println("Flight #" + landed.flightNumber + " landed. Wait time: " + wait);
    }
    
    private void takeoffPlane(double currentTime) {
        Plane takenOff = takeoffQ.dequeue();
        countTakeOff++;
        int wait = reportTime(currentTime, takenOff.arrivalTime);
        System.out.println("Flight #" + takenOff.flightNumber + " took off. Wait time: " + wait);
    }

    public void processTimeStep(double currentTime) {
        System.out.println("\n--- Time Step: " + currentTime + " ---");
        System.out.println("Planes in air (Landing Queue): " + landingQ.sizeOf());
        System.out.println("Planes on ground (Takeoff Queue): " + takeoffQ.sizeOf());

        if (!landingQ.isEmpty()) {
            landPlane(currentTime);
        } 
        else if (!takeoffQ.isEmpty()) {
            takeoffPlane(currentTime);
        } 
        else {
            System.out.println("Runway is idle.");
        }
    }
    
    public void addPlaneToLanding(Plane plane) {
        landingQ.enqueue(plane);
    }

    public void addPlaneToTakeoff(Plane plane) {
        takeoffQ.enqueue(plane);
    }
}
