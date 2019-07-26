package com.web.project.command;

import com.web.project.command.commandimpl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {

    private static CommandManager instance = new CommandManager();
    private Map<CommandContainer, Command> commands = new HashMap<>();


    private CommandManager() {
        commands.put(CommandContainer.TO_REGISTER, new RegisterPage());
        commands.put(CommandContainer.TO_LOGIN, new LoginPage());
        commands.put(CommandContainer.REGISTER, new RegisterUserCommand());
        commands.put(CommandContainer.RU, new ChangeLocaleCommand());
        commands.put(CommandContainer.EN, new ChangeLocaleCommand());
        commands.put(CommandContainer.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandContainer.LOGIN, new SignUserCommand());
    }


    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandContainer command = CommandContainer.valueOf(commandName.toUpperCase());
        return commands.get(command);
    }
}
