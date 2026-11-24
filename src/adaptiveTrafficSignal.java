
class Road {
    String name;
    int queueLength;
    int maxWaitingTime;

    Road(String name, int queueLength, int maxWaitingTime) {
        this.name = name;
        this.queueLength = queueLength;
        this.maxWaitingTime = maxWaitingTime;
    }
}

public class AdaptiveTrafficSignal {

    static final int MIN_GREEN = 8;
    static final int MAX_GREEN = 40;
    static final int STARTUP_TIME = 2;
    static final int SERVICE_TIME = 2;

    // Select the road with the longest-waiting vehicle
    static Road selectRoad(Road[] roads) {

        Road selected = null;

        for (Road road : roads) {

            if (road.queueLength <= 0) {
                continue;
            }

            if (selected == null
                || road.maxWaitingTime > selected.maxWaitingTime
                || (road.maxWaitingTime == selected.maxWaitingTime
                && road.queueLength > selected.queueLength)) {

                selected = road;
            }
        }

        return selected;
    }

    // Calculate green duration based on queue length
    static int calculateGreenTime(Road road) {

        int rawGreenTime =
                STARTUP_TIME + (road.queueLength * SERVICE_TIME);

        return Math.min(
                MAX_GREEN,
                Math.max(MIN_GREEN, rawGreenTime)
        );
    }

    public static void main(String[] args) {

        Road[] roads = {
            new Road("North", 8, 35),
            new Road("East", 4, 50),
            new Road("South", 10, 25),
            new Road("West", 0, 0)
        };

        Road selected = selectRoad(roads);

        if (selected == null) {
            System.out.println("No waiting traffic.");
            return;
        }

        int greenTime = calculateGreenTime(selected);

        System.out.println("Selected Road: " + selected.name);
        System.out.println("Queue Length: " + selected.queueLength);
        System.out.println("Longest Waiting Time: "
                + selected.maxWaitingTime + " seconds");
        System.out.println("Allocated Green Time: "
                + greenTime + " seconds");
    }
}
