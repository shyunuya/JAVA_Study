package practice;
/*

Problem Statement: In a Formula-1 challenge, there are n teams numbered 1 to n. Each team has a car and a driver. Car’s specification are as follows:
– Top speed: (150 + 10 * i) km per hour
– Acceleration: (2 * i) meter per second square.
– Handling factor (hf) = 0.8
– Nitro : Increases the speed to double or top speed, whichever is less. Can be used only once.

Here i is the team number.
The cars line up for the race. The start line for (i + 1)th car is 200 * i meters behind the ith car.

All of them start at the same time and try to attain their top speed. A re-assessment of the positions is done every 2 seconds(So even if the car has crossed the finish line in between, you’ll get to know after 2 seconds).
During this assessment, each driver checks if there is any car within 10 meters of his car, his speed reduces to: hf * (speed at that moment). Also, if the driver notices that he is the last one on the race, he uses ‘nitro’.

Taking the number of teams and length of track as the input, Calculate the final speeds and the corresponding completion times.

@From https://www.geeksforgeeks.org/google-interview-question-for-java-position/

Code from https://github.com/rajatIIT/interview_question_practice/blob/master/src/interviewquestions/SpeedCalculator.java

 */
public class TestGround {
    public static void main(String[] args) {
        SpeedCalculator sc = new SpeedCalculator();
        sc.computeFinalSpeedAndTime(10,10000);
    }
}

class SpeedCalculator {

    public SpeedCalculator() {

    }

    float[] top_speed;
    float[] acceleration;
    float[] distance;
    float[] current_speed;
    float[] current_time;
    float[] finishing_time;
    boolean[] raceCompleted;
    boolean[] nitroUsed;

    int num_cars;
    int time;
    float track_length;

    public void computeFinalSpeedAndTime (int num_cars, int track_length) {
        time = 0;
        this.num_cars = num_cars;
        this.track_length = track_length;

        // static lists
        top_speed = new float[num_cars];
        acceleration = new float[num_cars];
        finishing_time = new float[num_cars];

        // Dynamic lists
        distance = new float[num_cars];
        nitroUsed = new boolean[num_cars];
        raceCompleted = new boolean[num_cars];
        current_speed = new float[num_cars];
        current_time = new float[num_cars];

        for (int i=0; i < num_cars; i++) {
            raceCompleted[i] = false;
            nitroUsed[i] = false;
        }

        computeStartPositions();

        initializeTopSpeed();

        initializeAcceleration();

        while (!raceComplete()){
            System.out.println("------------------------------------------------------ ");
            System.out.println("Updating status at t = " + time);

            float distance_covered;

            System.out.println("-------------------------------------------------------");
            System.out.println("Updating all distance");

            for (int i = 0; i < num_cars; i++) {
                distance_covered = 2 * current_speed[i];

                distance[i] += distance_covered;
                System.out.println("New Distance of " + (i+1) + " th car is " + distance[i]);
            }

            System.out.println("-------------------------------------------------------");
            System.out.println("Updating all speeds.");
            float temp_speed;

            for (int i = 0; i<num_cars;i++) {
                temp_speed = current_speed[i] + (2 * acceleration[i]);

                if (temp_speed <= top_speed[i]) {
                    current_speed[i] = temp_speed; //current speed can't be faster than top speed
                }

                System.out.println("New speed of " + (i + 1) + " th car is " + current_speed[i]);
            }

            System.out.println("-------------------------------------------------------");
            System.out.println("Checking to see if there is any car within 10 meters.");
            for (int i = 0; i < num_cars; i++) {
                if (checkCarWithin10m(i)) {
                    //reduce car speed
                    current_speed[i] = current_speed[i] * 0.8f;
                    System.out.println("Reduced current car speed to " + current_speed[i]);
                }
            }





        }


    }

    private void computeStartPositions() {
        System.out.println("--------------------------------------------------");
        System.out.println("Calculating start positions.");
        System.out.println("Initial start position for 1 th car is 0.");
        distance[0] = 0;

        for (int i = 1; i < num_cars; i++) {
            distance[i] = distance[i -1] - (200 * i);
            System.out.println("Initial Start Distance for " + (i + 1) + " th car is " + distance[i] + ". ");
        }

        if (distance[num_cars - 1] > (-1)*track_length) {
            System.out.println("All the cars are aligned on the track");
        } else {
            System.out.println("All cars cannot come on track.");
            System.exit(1);
        }

    }

    private void initializeTopSpeed() {
        System.out.println("--------------------------------------------------");
        System.out.println("Calculating Top Speeds");

        for (int i = 0; i < num_cars; i++) {
            top_speed[i] = (150 + 10 * (i+1));
            current_speed[i] = 0.0f;
            System.out.println("The top speed for the " + (i+1) + " th car is " + top_speed[i]);
        }
    }

    private void initializeAcceleration() {
        System.out.println("--------------------------------------------------");
        System.out.println("Calculating Accelerations");

        for (int i = 0; i < num_cars; i++) {
            acceleration[i] = (2 * (i + 1));
            System.out.println("The acceleration for the " + (i+1) + " th car is " + acceleration[i]);

        }
    }

    private boolean checkCarWithin10m (int currentNthCar) {
        for(int i = 0 ; i < num_cars; i++) {

        }
    }
}
