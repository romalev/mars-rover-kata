package app.rover.kata;

import app.rover.kata.model.Location;
import org.junit.jupiter.api.Test;

import static app.rover.kata.model.Location.Direction.EAST;
import static app.rover.kata.model.Location.Direction.NORTH;
import static app.rover.kata.model.Location.Direction.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Given test suite tests top to bottom entire logic of this application
 * so there's no need and sense to write test class per application class.
 */
class RoverKataTestingSuite {
    @Test
    void issueWrongCommand() {
        final CommandExecutor commandExecutor = new CommandExecutor();

        assertThrows(
                CommandInvalidException.class,
                () -> commandExecutor.execute("FLZXV", new Location(4, 2, NORTH))
        );
    }

    @Test
    void issueFLFFFRFLFCommand() {
        verify("FLFFFRFLF", new Location(4, 2, NORTH), new Location(0, 4, WEST));
    }

    @Test
    void issueFLFFFRFLRCommand() {
        verify("FLFFFRFLR", new Location(4, 2, EAST), new Location(6, 5, EAST));
    }

    @Test
    void issueFLFFFFRFFLBBFRBLBLBLBRBRFFFRFCommand() {
        verify("FLFFFFRFFLBBFRBLBLBLBRBRFFFRF", new Location(4, 2, EAST), new Location(9, 8, EAST));
    }

    @Test
    void issueFLFFFRFLBCommand() {
        verify("FLFFFRFLB", new Location(4, 2, EAST), new Location(6, 4, NORTH));
    }

    void verify(String command, Location initLocation, Location expectedLocation) {
        final CommandExecutor commandExecutor = new CommandExecutor();
        final Location actualLocation = commandExecutor.execute(command, initLocation);
        assertEquals(expectedLocation, actualLocation);
    }
}
