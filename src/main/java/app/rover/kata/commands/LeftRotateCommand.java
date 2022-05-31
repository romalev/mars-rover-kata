package app.rover.kata.commands;

import app.rover.kata.model.Location;

public class LeftRotateCommand extends BaseCommand {
    @Override
    protected Location executeOnNorth(final Location current) {
        return new Location(current.getX(), current.getY(), Location.Direction.WEST);
    }

    @Override
    protected Location executeOnSouth(final Location current) {
        return new Location(current.getX(), current.getY(), Location.Direction.EAST);
    }

    @Override
    protected Location executeOnWest(final Location current) {
        return new Location(current.getX(), current.getY(), Location.Direction.SOUTH);
    }

    @Override
    protected Location executeOnEast(final Location current) {
        return new Location(current.getX(), current.getY(), Location.Direction.NORTH);
    }

    @Override
    public Character getCode() {
        return 'L';
    }
}
