import java.util.Timer;
import java.util.TimerTask;

public class clock {
    Timer t;
    int minutes = 0; // 15 minute games
    boolean timerEnded = false;
    String name = "";

    // create the new timer and schedule the timer to run for 15 minutes
    public void countDownTimer() {
        t = new Timer();
        t.schedule(new rt(), minutes * 60 * 1000); // convert to milliseconds
    }

    // run timer and print when finished
    class rt extends TimerTask {
        public void run() {
            System.out.println(name + "'s timer has finished.");
            timerEnded = true;
            t.cancel(); // end timer
        }
    }
}
