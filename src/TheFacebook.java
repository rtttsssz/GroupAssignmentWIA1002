import java.util.*;
public class TheFacebook {
    static LinkedList<Interaction> interactions = new LinkedList<>();
    public static void main(String[] args) {


        // Example usage for login function
        Interaction loginInteraction = new Interaction("login");
        interactions.add(loginInteraction);

    }

    // Example traceback function
    public void traceback() {
        if (interactions.isEmpty()) {
            System.out.println("No interactions found in current session.");
        } else {
            Interaction lastInteraction = interactions.getLast();
            System.out.println("Last interaction: " + lastInteraction.getFunctionName());
            System.out.println("Timestamp: " + lastInteraction.getTimestamp());

            // We can continue traversing the linked list to get more information about previous interactions
        }
    }

}
