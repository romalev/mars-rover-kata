package app.rover.kata.model;

import java.util.Objects;

public final class Location {
    private final int x;
    private final int y;
    private final Direction facing;

    public Location(final int x, final int y, final Direction facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getFacing() {
        return facing;
    }

    public enum Direction {
        EAST,
        WEST,
        NORTH,
        SOUTH
    }

    @Override
    public String toString() {
        return "(" +
                x + "," +
                y + "," +
                facing.toString() +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y && facing == location.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }
}
