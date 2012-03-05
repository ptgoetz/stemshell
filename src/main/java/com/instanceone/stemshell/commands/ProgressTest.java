// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.stemshell.commands;

import java.io.IOException;

import jline.console.ConsoleReader;

import org.apache.commons.cli.CommandLine;

import com.instanceone.stemshell.Environment;
import com.instanceone.stemshell.command.AbstractCommand;
import com.instanceone.stemshell.progress.PercentageIndicator;

public class ProgressTest extends AbstractCommand {

    public ProgressTest(String name) {
        super(name);
    }

    public void execute(Environment env, CommandLine cmd, ConsoleReader reader)
                    throws IOException {
        PercentageIndicator progress = new PercentageIndicator(reader, 0L, 100L);
        progress.setLabel("Uploading: foo.txt ");
        for (int i = 0; i <= 100; i++) {
            progress.progress(new Long(i));
            try {
                Thread.sleep(50);
            }
            catch (InterruptedException e) {
            }
        }
        System.out.println();
    }

    @Override
    public String getHelpHeader() {
        return "show a simulated progress indicator";
    }

    @Override
    public String getUsage() {
        return this.getName();
    }

}
