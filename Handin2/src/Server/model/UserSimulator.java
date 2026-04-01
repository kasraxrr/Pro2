package Server.model;

import Server.model.LP;
import Server.model.LoanedAndReservedState;
import Server.model.LoanedState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


public class UserSimulator implements Runnable, PropertyChangeListener {

    private Model  model;
    private String name;

    public UserSimulator(Model model, String name) {
        this.model = model;
        this.name  = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("[" + name + "] Model changed: " + evt.getPropertyName());
    }

    @Override
    public void run() {
        System.out.println("[" + name + "] Simulation started.");

        // THIS LOOP KEEPS THE THREAD ALIVE FOREVER
        while (!Thread.currentThread().isInterrupted()) {
            try {
                tryReserve();
                Thread.sleep(20000);
                Log.getInstance("simulator").addLog("Simulated reserve of LP");

                tryLoan();
                Thread.sleep(20000);
                Log.getInstance("simulator").addLog("Simulated loan of LP");

                tryReturn();
                Thread.sleep(20000);
                Log.getInstance("simulator").addLog("Simulated return of LP");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + name + "] Simulation stopped.");
                break; // Exit the loop if the thread is killed
            }
        }
    }

    private void tryReserve() {
        ArrayList<LP> lps = new ArrayList<>(model.getAllLPs());
        if (lps == null || lps.isEmpty()) return;

        for (LP lp : lps) {
            if (lp.getState() instanceof AvailableState && !lp.isFlagged()) {
                System.out.println("[" + name + "] Reserving: " + lp.getTitle());
                model.reserve(lp, name);
                return;
            }
        }
        System.out.println("[" + name + "] Nothing to reserve.");
    }

    public void tryLoan() {
        ArrayList<LP> lps = new ArrayList<>(model.getAllLPs());
        if (lps == null || lps.isEmpty()) return;

        for (LP lp : lps) {
            if (lp.getState() instanceof AvailableState) {
                System.out.println("[" + name + "] Loaning: " + lp.getTitle());
                model.loan(lp, name);
                return;
            }
            if (lp.getState() instanceof ReservedState rs && name.equals(rs.getReservedBy())) {
                System.out.println("[" + name + "] Loaning reserved LP: " + lp.getTitle());
                model.loan(lp, name);
                return;
            }
        }
        System.out.println("[" + name + "] Nothing to loan.");
    }

    public void tryReturn() {
        ArrayList<LP> lps = new ArrayList<>(model.getAllLPs());
        if (lps == null || lps.isEmpty()) return;

        for (LP lp : lps) {
            if (lp.getState() instanceof LoanedState ls && name.equals(ls.getLoanedTo())) {
                System.out.println("[" + name + "] Returning: " + lp.getTitle());
                model.returnLP(lp);
                return;
            }
            if (lp.getState() instanceof LoanedAndReservedState lars && name.equals(lars.getLoanedTo())) {
                System.out.println("[" + name + "] Returning: " + lp.getTitle());
                model.returnLP(lp);
                return;
            }
        }
        System.out.println("[" + name + "] Nothing to return.");
    }

    public Model  getModel() { return model; }
    public String getName()  { return name;  }
}

