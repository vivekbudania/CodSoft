import java.util.Timer;
import java.util.TimerTask;

public class QuestionTimer {
    private Timer timer;
    private boolean timeUp;

    public QuestionTimer(int seconds) {
        timer = new Timer();
        timeUp = false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                timer.cancel();
            }
        }, seconds * 1000);
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public void cancel() {
        timer.cancel();
    }
}
