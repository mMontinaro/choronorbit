package io.github.mmontinaro.chronorbit.cli;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import io.github.mmontinaro.chronorbit.constants.CliConstants;
import io.github.mmontinaro.chronorbit.model.enums.TimestampFormat;

public class InteractiveMenu {
    private final Scanner scanner;
    private final PrintStream printStream;


    public InteractiveMenu(Scanner s, PrintStream ps){
        this.scanner = s;
        this.printStream = ps;
    }

    public InputConfig display(){
        displayInit();

        TimestampFormat f = selectTimeFormat();
        return new InputConfig(f, selectDelim(f));

    }

    public void help(){
    
        displayHelp(
            CliConstants.HELP_STRING.replace(
                "%s", 
                this.buildDynamicHelpMsg()
            ));
    }


    private void displayInit(){
        println(CliConstants.INIT_STRING);
    }

    private void displayHelp(String msg){
        println(msg);
    }

    private TimestampFormat selectTimeFormat(){
        while(true){
            println(CliConstants.SELECT_TIME_FORMAT);
            print(CliConstants.ENTER_SELECTION);

            switch(scanner.nextLine().strip()){
                case "", "1":
                    return TimestampFormat.TIMESTAMP;
                case "2":
                    return TimestampFormat.CCSDS_ASCII_TIME_CODE_A;
                default:
                    println(CliConstants.INVALID_SELECTION);
                    println("");
            }
        }
    }

    private String selectDelim(TimestampFormat format){
        while(true){
            print(CliConstants.ENTER_DELIM);

            String delim = scanner.nextLine().strip();

            if(delim.isEmpty() || delim.isBlank()){
                delim = ",";
            }

            if (format.isValidDelim(delim)) {
                return delim;
            }

            println(CliConstants.INVALID_DELIM + " " + format.getForbiddenDelims());

        }
    }

    private void println(String msg){
        printStream.println(msg);
    }

    private void print(String msg){
        printStream.print(msg);
    }

    private String buildDynamicHelpMsg(){
        StringBuilder fullMsg = new StringBuilder();
        String line; 

        String pattern = this.buildTimestampPattern();
        
        for(TimestampFormat f : TimestampFormat.values()){

            line = pattern.formatted(f.getFormat(), f.getPattern(), f.getForbiddenDelims());
            fullMsg = fullMsg.append(line);
        }

        return fullMsg.toString();
    }

    private String buildTimestampPattern(){
        int maxLengthFormat = Arrays.stream(TimestampFormat.values())
            .mapToInt(format -> format.getFormat().length())
            .max()
            .orElse(0);

        int maxLengthPattern = Arrays.stream(TimestampFormat.values())
            .mapToInt(format -> format.getPattern().length())
            .max()
            .orElse(0);

        return "    %-" + (maxLengthFormat + 4)
                        + "s%-" + (maxLengthPattern + 4) 
                        + "s%s%n";
    }
}
