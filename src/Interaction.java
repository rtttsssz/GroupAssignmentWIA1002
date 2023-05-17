import java.time.LocalDateTime;

public class Interaction {
    private String functionName;
    private LocalDateTime timestamp;
    private Interaction previousInteraction;

    public Interaction(String functionName) {
        this.functionName = functionName;
        this.timestamp = LocalDateTime.now();
    }

    public String getFunctionName() {
        return functionName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Interaction getPreviousInteraction() {
        return previousInteraction;
    }

    public void setPreviousInteraction(Interaction previousInteraction) {
        this.previousInteraction = previousInteraction;
    }
}
