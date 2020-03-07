package com.epam.lab.patterns.state_kanban_board.stateimpl;

import com.epam.lab.patterns.state_kanban_board.State;
import com.epam.lab.patterns.state_kanban_board.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DoneState  implements State {
    private static final Logger log = LogManager.getLogger(DoneState.class);

    @Override
    public void doneState(Ticket ticket) {
        ticket.setState(new DoneState());
        log.info("Done state is set");
    }

    @Override
    public void addToDoState(Ticket ticket) {
        log.info("Item is added into ToDo list.");
    }
}
