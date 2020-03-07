package com.epam.lab.patterns.state_kanban_board.stateimpl;

import com.epam.lab.patterns.state_kanban_board.State;
import com.epam.lab.patterns.state_kanban_board.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToDoState implements State {
    private static final Logger log = LogManager.getLogger(ToDoState.class);
    @Override
    public void addToDoState(Ticket ticket) {
       log.info("Item is added into ToDo list.");
    }

    @Override
    public void inProgressState(Ticket ticket) {
        ticket.setState(new InProgressState());
        log.info("InProgress state is set");
    }

}
