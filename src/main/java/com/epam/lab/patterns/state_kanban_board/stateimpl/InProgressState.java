package com.epam.lab.patterns.state_kanban_board.stateimpl;

import com.epam.lab.patterns.state_kanban_board.State;
import com.epam.lab.patterns.state_kanban_board.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InProgressState implements State {
    private static final Logger log = LogManager.getLogger(InProgressState.class);

    @Override
    public void inProgressState(Ticket ticket) {
        ticket.setState(new InProgressState());
        log.info("InProgress state is set");
    }

    @Override
    public void codeReviewState(Ticket ticket) {
        ticket.setState(new CodeReviewState());
        log.info("CodeReview state is set");
    }
}
