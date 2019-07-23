package com.web.project.command.commandimpl;

import com.web.project.command.Command;
import com.web.project.command.CommandContainer;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static CommandManager instance = new CommandManager();
    private Map<CommandContainer, Command> commands = new HashMap<>();


    private CommandManager() {
        commands.put(CommandContainer.TO_REGISTER, new RegisterPage());
        commands.put(CommandContainer.TO_LOGIN, new LoginPage());
        commands.put(CommandContainer.REGISTER, new RegisterUserCommand());
    }


    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandContainer command = CommandContainer.valueOf(commandName.toUpperCase());
        return commands.get(command);
    }
}
