package com.epam.lab.patterns.state_kanban_board;

import com.epam.lab.patterns.state_kanban_board.stateimpl.ToDoState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ticket {
    private static final Logger log = LogManager.getLogger(Ticket.class);
    private State state;

    public Ticket() {
        state = new ToDoState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void addToDoState() {
        state.addToDoState(this);
    }

    public void inProgressState() {
        state.inProgressState(this);
    }

    public void codeReviewState() {
        state.codeReviewState(this);
    }

    public void doneState() {
        state.doneState(this);
    }

    public void showCurrentState() {
        log.info(state.getClass().getSimpleName());
    }

}
