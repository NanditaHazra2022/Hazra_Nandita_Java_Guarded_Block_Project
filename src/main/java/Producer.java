// Import required class.
import java.util.Random;

// Use Runnable interface to have method: run
// for containing the code executed in the thread.
public class Producer implements Runnable {
    private Drop drop1;

    // Constructor
    public Producer(Drop drop1) {
        this.drop1 = drop1;
    }

    public void run() {

        // Create message to be exchanged.
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        Random random = new Random();

        // Call put method of Drop class
        // to send message
        for (int i = 0;
             i < importantInfo.length;
             i++) {

            drop1.put(importantInfo[i]);

            // pause for 5 seconds
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                System.err.println("Caught InterruptedException"
                        +  e.getMessage());
            }

        }

        drop1.put("DONE");
    }

}