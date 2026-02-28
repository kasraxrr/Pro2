package model;

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


            try {
                // Step 1: reserve
                tryReserve();
                Thread.sleep(30000);

                // Step 2: loan the reservation
                tryLoan();
                Thread.sleep(30000);

                // Step 3: return the LP
                tryReturn();
                Thread.sleep(30000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[" + name + "] Simulation stopped.");
            }

    }

    private void tryReserve() {
        ArrayList<LP> lps = model.getAllLPs();
        if (lps == null || lps.isEmpty()) return;

        for (LP lp : lps) {
            if ((lp.getState() instanceof AvailableState || lp.getState() instanceof LoanedState)
                    && !lp.isFlagged()) {
                System.out.println("[" + name + "] Reserving: " + lp.getTitle());
                model.reserve(lp, name);
                return;
            }
        }
        System.out.println("[" + name + "] Nothing to reserve.");
    }

    private void tryLoan() {
        ArrayList<LP> lps = model.getAllLPs();
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

    private void tryReturn() {
        ArrayList<LP> lps = model.getAllLPs();
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

