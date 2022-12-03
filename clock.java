import java.util.Timer;
import java.util.TimerTask;

public class clock {
    Timer t;
    int minutes = 15;
    int elapsedTime = 0;
    boolean turn = false;
    boolean timeOut = false;
    String name = "";

    // create the new timer and schedule the timer to run for 15 minutes
    public void runTimer(int elapsedTime) {
        if(elapsedTime == (minutes * 60))
            timeOut = true;

        // if it is the player's turn then run a 1 second timer
        if(turn = true) {
            t = new Timer();
            t.schedule(new rt(), 1000); // convert to milliseconds
        }
    }

    // run timer and print when finished
    class rt extends TimerTask {
        public void run() {
            elapsedTime++;
            //timeLeft(elapsedTime);
            t.cancel(); // end timer
            runTimer(elapsedTime);
        }
    }

    public void timeLeft(int time) {
        int min;
        int sec;

        // calculate time in minutes and seconds
        min = minutes - (time / 60) - 1;
        sec = 60 - (time % 60);

        // print remaining time
        if(sec == 60 && min != 0)
            System.out.println(name + "'s time left is " + (min + 1) + ":00");
        else
            System.out.println(name + "'s Time left is " + min + ":" + sec);
    }
}
