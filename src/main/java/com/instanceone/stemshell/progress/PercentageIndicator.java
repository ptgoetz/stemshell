// Copyright (c) 2012 P. Taylor Goetz (ptgoetz@gmail.com)

package com.instanceone.stemshell.progress;

import org.fusesource.jansi.Ansi;

import jline.Terminal;
import jline.console.ConsoleReader;

public class PercentageIndicator {
    private String label = "";
    private Terminal terminal;

    private Long minimum = 0L;
    private Long maximum = 100L;
    private Long current = 0L;

    public PercentageIndicator(ConsoleReader reader, Long min, Long max) {
        this.terminal = reader.getTerminal();
        this.minimum = min;
        this.maximum = max;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    private void renderAnsi() {
        int height = terminal.getHeight();

        Ansi ansi = Ansi.ansi();
        ansi.cursor(height, 0);
        ansi.eraseLine(Ansi.Erase.FORWARD);
        ansi.a(this.label + calcPercent(this.minimum, this.current, this.maximum) + "%");
        System.out.print(ansi);
        System.out.flush();
    }

    public void progress(Long progress) {
        this.current = progress;
        renderAnsi();
    }

    static int calcPercent(Long min, Long current, Long max) {
        current = current - min;
        max = max - min;
        return (int) (((double) current / (double) max) * 100);
    }


}
