// Import required class.
import java.util.Random;

// Use Runnable interface to have method: run
// for containing the code executed in the thread.
public class Consumer implements Runnable {
    private Drop drop2;

    // Constructor
    public Consumer(Drop drop2) {
        this.drop2 = drop2;
    }

    public void run() {
        Random random = new Random();

        // Call take method of Drop class
        // to retrieve message
        for (String message = drop2.take();
             ! message.equals("DONE");
             message = drop2.take()) {

            System.out.format("MESSAGE RECEIVED: %s%n", message);

            // Pause for 5 seconds.
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.err.println("Caught InterruptedException"
                        +  e.getMessage());
            }

        }

    }
}