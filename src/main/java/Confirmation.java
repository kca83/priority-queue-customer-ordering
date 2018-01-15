import java.util.Comparator;

public class Confirmation implements Comparable<Confirmation> {

    private Integer id;
    private Integer priority;
    private Integer occursAt;

    public Confirmation(int id, int priority, int occursAt) {
        this.id = id;
        this.priority = priority;
        this.occursAt = occursAt;
    }

    public int compareTo(Confirmation confirmation) {
        int order = priority.compareTo(confirmation.priority);
        if(order != 0) {
            return order;
        }
        else {
            return occursAt.compareTo(confirmation.occursAt);
        }
    }

    public int compareByTime(Confirmation confirmation) {
        return occursAt.compareTo(confirmation.occursAt);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getOccursAt() {
        return occursAt;
    }

    public void setOccursAt(Integer occursAt) {
        this.occursAt = occursAt;
    }

    @Override
    public String toString() {
        return String.format("{ Priority: %d, Time Occurs At: %d, Index: %d }", priority, occursAt, id);
    }
}
