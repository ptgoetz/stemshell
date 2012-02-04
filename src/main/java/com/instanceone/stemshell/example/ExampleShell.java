// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.stemshell.example;

import com.instanceone.stemshell.AbstractShell;
import com.instanceone.stemshell.Environment;
import com.instanceone.stemshell.commands.Env;
import com.instanceone.stemshell.commands.Exit;
import com.instanceone.stemshell.commands.Help;

public class ExampleShell extends AbstractShell {
    
    public static void main(String[] args) throws Exception{
        new ExampleShell().run(args);
    }

    @Override
    public void initialize(Environment env) throws Exception {
        env.addCommand(new Exit("exit"));
        env.addCommand(new Env("env"));
        env.addCommand(new Help("help", env));
        env.setPrompt("stemshell%");
    }

}
