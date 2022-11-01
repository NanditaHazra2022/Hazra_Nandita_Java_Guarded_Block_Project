package ProducerConsumer;

// Using Runnable interface to have method: run
// for containing the code executed in the thread.
public class Producer implements Runnable {
    private final Drop drop1;

    // Constructor
    public Producer(Drop drop1) {
        this.drop1 = drop1;
    }

    public void run() {

        // Create message to be exchanged.
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        // Call put method of Drop class
        // to send message
        for (String str: importantInfo) {
            drop1.put(str);
        }

        drop1.put("DONE");
    }

}