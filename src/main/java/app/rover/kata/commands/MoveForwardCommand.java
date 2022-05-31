package app.rover.kata.commands;

import app.rover.kata.model.Location;

public class MoveForwardCommand extends BaseCommand {
    @Override
    protected Location executeOnNorth(final Location current) {
        return new Location(current.getX(), current.getY() + 1, current.getFacing());
    }

    @Override
    protected Location executeOnSouth(final Location current) {
        return new Location(current.getX(), current.getY() - 1, current.getFacing());
    }

    @Override
    protected Location executeOnWest(final Location current) {
        return new Location(current.getX() - 1, current.getY(), current.getFacing());
    }

    @Override
    protected Location executeOnEast(final Location current) {
        return new Location(current.getX() + 1, current.getY(), current.getFacing());
    }

    @Override
    public Character getCode() {
        return 'F';
    }
}
