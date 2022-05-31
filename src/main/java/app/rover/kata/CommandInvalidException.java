package app.rover.kata;

/**
 * Thrown in case command that is to be supplied for an execution is invalid.
 */
public class CommandInvalidException extends RuntimeException {
    private final String exceptionMessage;


    public CommandInvalidException(final Character command) {
        exceptionMessage = String.format(
                "Input command '%s' is invalid. Please check your input command and try again.", command
        );
    }

    @Override
    public String getMessage() {
        return exceptionMessage;
    }

}
