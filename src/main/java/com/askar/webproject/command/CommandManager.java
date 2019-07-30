package com.askar.webproject.command;

import com.askar.webproject.command.impl.*;

import java.util.EnumMap;

public class CommandManager {
    enum CommandContainer {
        EMPTY_COMMAND,
        TO_REGISTER,
        TO_LOGIN,
        REGISTER,
        LOGIN,
        RESULT_REGISTER,
        RU,
        EN,
        CHANGE_LOCALE,
        TO_CART,
        LOGOUT,
        USER_MENU,
        TO_ORDER_HISTORY
    }

    private static CommandManager instance = new CommandManager();
    private EnumMap<CommandContainer, Command> commands = new EnumMap<>(CommandContainer.class);


    private CommandManager() {
        commands.put(CommandContainer.TO_REGISTER, new ToRegisterPageCommand());
        commands.put(CommandContainer.TO_LOGIN, new ToLoginPageCommand());
        commands.put(CommandContainer.REGISTER, new RegisterUserCommand());
        commands.put(CommandContainer.RU, new ChangeLocaleCommand());
        commands.put(CommandContainer.EN, new ChangeLocaleCommand());
        commands.put(CommandContainer.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandContainer.LOGIN, new SignUserCommand());
        commands.put(CommandContainer.EMPTY_COMMAND, new EmptyCommand());
        commands.put(CommandContainer.TO_CART, new CartPageCommand());
        commands.put(CommandContainer.LOGOUT, new LogOutCommand());
        commands.put(CommandContainer.USER_MENU, new ToUserMenuCommand());
        commands.put(CommandContainer.USER_MENU, new ToUserMenuCommand());

    }


    public static CommandManager getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        CommandContainer command = CommandContainer.valueOf(commandName.toUpperCase());
        return commands.get(command);
    }
}
