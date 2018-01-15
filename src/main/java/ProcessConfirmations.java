import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class ProcessConfirmations {

    ArrayList<Confirmation> confirmations = new ArrayList<Confirmation>();
    ArrayList<Confirmation> processedConfirmations = new ArrayList<Confirmation>();

    public Integer[] orderOfConfirmations(Integer[] inputTime, Integer[] inputPriority) {
        assert inputTime.length == inputPriority.length;

        createConfirmations(inputTime, inputPriority);
        System.out.println(confirmations);

        Confirmation currentlyProcessing = null;
        int confirmationDoneProcessingAt = 0;
        PriorityQueue<Confirmation> waitingToBeProcessed = new PriorityQueue<Confirmation>();
        while(!confirmations.isEmpty() || !waitingToBeProcessed.isEmpty()) {
            Confirmation current = null;
            if(!confirmations.isEmpty()) {
                current = confirmations.get(0);
                System.out.println("current " + current);
                confirmations.remove(0);

                if (currentlyProcessing == null) {
                    currentlyProcessing = current;
                    processedConfirmations.add(currentlyProcessing);
                    confirmationDoneProcessingAt = currentlyProcessing.getOccursAt() + 60;
                    System.out.println(currentlyProcessing + "done at " + confirmationDoneProcessingAt);
                }
            }

            if(current != null && !processedConfirmations.contains(current) && current.getOccursAt() <= confirmationDoneProcessingAt) {
                waitingToBeProcessed.offer(current);
            }
            else {
                while(!waitingToBeProcessed.isEmpty() && (current == null || current.getOccursAt() > confirmationDoneProcessingAt)) {
                    currentlyProcessing = waitingToBeProcessed.poll();
                    processedConfirmations.add(currentlyProcessing);
                    confirmationDoneProcessingAt += 60;
                    System.out.println(currentlyProcessing + "done at " + confirmationDoneProcessingAt);
                }

                if(current != null && !processedConfirmations.contains(current) && current.getOccursAt() <= confirmationDoneProcessingAt) {
                    waitingToBeProcessed.offer(current);
                }
                else if(current != null && current.getOccursAt() > confirmationDoneProcessingAt) {
                    currentlyProcessing = current;
                    processedConfirmations.add(currentlyProcessing);
                    confirmationDoneProcessingAt = currentlyProcessing.getOccursAt() + 60;
                    System.out.println(currentlyProcessing + "done at " + confirmationDoneProcessingAt);
                }
            }
        }
        Integer[] order = new Integer[inputPriority.length];
        for(int i = 0; i < order.length; i++) {
            order[i] = processedConfirmations.get(i).getId();
        }
        return order;
    }

    public void createConfirmations(Integer[] inputTime, Integer[] inputPriority) {
        for(int i = 0; i < inputTime.length; i++) {
            confirmations.add(new Confirmation(i, inputPriority[i], inputTime[i]));
        }
        Collections.sort(confirmations, new TimeComparator());
    }
}
