// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.stemshell.command;

import jline.console.ConsoleReader;
import jline.console.completer.Completer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.instanceone.stemshell.Environment;

public interface Command {

    String getHelpHeader();
    String gethelpFooter();
    String getUsage();
    
    String getName();
    
    void execute(Environment env, CommandLine cmd, ConsoleReader reader) throws Exception;
    
    Options getOptions();
    
    Completer getCompleter();
}
