package io.github.mmontinaro.chronorbit.cli;

import java.io.PrintStream;
import java.util.Scanner;

import io.github.mmontinaro.chronorbit.common.Constants;
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


    private void displayInit(){
        println(Constants.Cli.INIT_STRING);
    }

    private TimestampFormat selectTimeFormat(){
        while(true){
            println(Constants.Cli.SELECT_TIME_FORMAT);
            print(Constants.Cli.ENTER_SELECTION);

            switch(scanner.nextLine().strip()){
                case "", "1":
                    return TimestampFormat.TIMESTAMP;
                case "2":
                    return TimestampFormat.CCSDS_ASCII_TIME_CODE_A;
                default:
                    println(Constants.Cli.INVALID_SELECTION)
                    println("");
            }
        }
    }

    private String selectDelim(TimestampFormat format){
        while(true){
            print(Constants.Cli.ENTER_DELIM);

            String delim = scanner.nextLine().strip();

            if(delim.isEmpty() || delim.isBlank()){
                delim = ",";
            }

            if (format.isValidDelim(delim)) {
                return delim;
            }

            println(Constants.Cli.INVALID_DELIM + " " + format.getForbiddenDelims());

        }
    }

    private void println(String msg){
        printStream.println(msg);
    }

    private void print(String msg){
        printStream.print(msg);
    }
}
