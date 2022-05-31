package app.rover.kata.commands;

import app.rover.kata.model.Location;

public interface Command {
    Character getCode();

    Location execute(final Location currentLocation);

    /**
     * Commands can/must all be recorded in a non-volatile memory so as soon as there is a power outage or system restart -
     * rover can quickly re-compute its position.
     */
    void record(final Location currentLocation, final Location nextLocation);
}
