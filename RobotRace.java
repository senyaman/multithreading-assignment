package robotrace;

public class RobotRace implements Runnable {

    private String name;
    private int number;

    public RobotRace(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        go();
        long end = System.currentTimeMillis();
        double duration = (double) (end - start)/1000;

        System.out.println(this.name + " " + this.number + " finished in " + duration + " seconds");
    }

    private void go() {

        int raceLength = 150;
        int distanceCovered = 1;

        int minSpeed = 1;
        int maxSpeed = 4;

        int randomSpeed = (int)Math.floor(Math.random()*(maxSpeed - minSpeed+1)+minSpeed);
        int stepCounter = 0;

        for (int i = 0; i < raceLength; i+=10) {
            if (distanceCovered * 10 < raceLength) {

                switch (randomSpeed) {
                    case 1:
                        distanceCovered++;
                        break;
                    case 2:
                        distanceCovered += 2;
                        break;
                    case 3:
                        distanceCovered += 3;
                        break;
                    case 4:
                        distanceCovered += 4;
                        break;
                }

                stepCounter++;

                if (stepCounter % 2 == 0) {
                    randomSpeed = (int)Math.floor(Math.random()*(maxSpeed - minSpeed+1)+minSpeed);
                }

            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
