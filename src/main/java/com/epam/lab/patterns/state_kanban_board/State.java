package com.epam.lab.patterns.state_kanban_board;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface State {
    Logger log = LogManager.getLogger(State.class);

    default void addToDoState(Ticket ticket) {
        log.info("addToDoState  is not allowed");
    }

    default void inProgressState(Ticket ticket) {
        log.info("inProgressState is not allowed");
    }

    default void codeReviewState(Ticket ticket) {
        log.info("codeReviewState is not allowed");
    }

    default void doneState(Ticket ticket) {
        log.info("doneState is not allowed");
    }

}
