package robotrace;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        System.out.println("New race started at " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        
        for (int i = 1; i < 11; i++) {
            RobotRace robot = new RobotRace("Robot", i);
            Thread thread = new Thread(robot);
            thread.start();
        }

    }

}
