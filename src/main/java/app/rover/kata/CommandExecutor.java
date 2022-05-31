package app.rover.kata;

import app.rover.kata.commands.Command;
import app.rover.kata.commands.LeftRotateCommand;
import app.rover.kata.commands.MoveBackwardsCommand;
import app.rover.kata.commands.MoveForwardCommand;
import app.rover.kata.commands.RightRotateCommand;
import app.rover.kata.model.Location;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CommandExecutor {
    private final Map<Character, Command> commandMap = Map.of(
            'B', new MoveBackwardsCommand(),
            'F', new MoveForwardCommand(),
            'R', new RightRotateCommand(),
            'L', new LeftRotateCommand()
    );
    private final Queue<Command> commandQueue = new LinkedList<>();

    public Location execute(final String commandRequest, final Location initLocation) {
        final char[] commands = commandRequest.toCharArray();
        validate(commands);
        queue(commands);
        return execute(pollCommand(), initLocation);
    }

    private void validate(final char[] commands) {
        final Set<Character> availableCommands = new HashSet<>(commandMap.keySet());
        for (final Character command : commands) {
            if (!availableCommands.contains(command)) {
                throw new CommandInvalidException(command);
            }
        }
    }

    private Location execute(final Command command, final Location current) {
        Location next = command.execute(current);
        return commandExists() ? execute(pollCommand(), next) : next;
    }

    private boolean commandExists() {
        return !commandQueue.isEmpty();
    }

    private Command pollCommand() {
        return commandQueue.poll();
    }

    private void queue(final char[] commands) {
        for (final Character command : commands) {
            commandQueue.add(commandMap.get(command));
        }
    }
}
