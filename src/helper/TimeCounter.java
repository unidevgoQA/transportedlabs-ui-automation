package helper;

public class TimeCounter {

    public static void timer(int minutes) throws InterruptedException {
        int time = minutes * 60 * 1000;
        while (time > 0) {
            // decrement minutes
            time-=10000;
            System.out.println("Time left: " +(float) time / 1000 / 60 + " minutes");
            Thread.sleep(10000);
        }
    }
}
