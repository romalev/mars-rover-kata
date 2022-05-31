package app.rover.kata.commands;

import app.rover.kata.model.Location;


public abstract class BaseCommand implements Command {
    protected abstract Location executeOnNorth(final Location current);

    protected abstract Location executeOnSouth(final Location current);

    protected abstract Location executeOnWest(final Location current);

    protected abstract Location executeOnEast(final Location current);

    @Override
    public void record(final Location current, final Location next) {
        // TODO: to be recorded in non-volatile memory
        System.out.println(
                String.format("%s: %s -> %s", getCode(), current.toString(), next)
        );
    }

    @Override
    public Location execute(final Location current) {
        switch (current.getFacing()) {
            case NORTH:
                Location nextOnNorth = executeOnNorth(current);
                record(current, nextOnNorth);
                return nextOnNorth;
            case EAST:
                Location nextOnEast = executeOnEast(current);
                record(current, nextOnEast);
                return nextOnEast;
            case WEST:
                Location nextOnWest = executeOnWest(current);
                record(current, nextOnWest);
                return nextOnWest;
            case SOUTH:
                Location nextOnSouth = executeOnSouth(current);
                record(current, nextOnSouth);
                return nextOnSouth;
            default:
                throw new RuntimeException("Direction is invalid");
        }
    }
}
