// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.stemshell.commands;

import jline.console.ConsoleReader;

import org.apache.commons.cli.CommandLine;

import com.instanceone.stemshell.Environment;
import com.instanceone.stemshell.command.AbstractCommand;

public class Exit extends AbstractCommand {

    public Exit(String name) {
        super(name);
    }

    public void execute(Environment env, CommandLine cmd, ConsoleReader reader) {
        System.exit(0);
    }

    @Override
    public String getHelpHeader() {
        return "exit the command shell";
    }

    @Override
    public String getUsage() {
        return this.getName();
    }
    
    

}
