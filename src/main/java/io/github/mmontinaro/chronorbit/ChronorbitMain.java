package io.github.mmontinaro.chronorbit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import io.github.mmontinaro.chronorbit.common.Constants;
import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.service.FileReader;

public class ChronorbitMain {
    public static void main(String[] args) {

        if(args.length != 1){
            System.err.println(Constants.ARG_NUM_INVALID);
            System.exit(1);
        }

        Path path = Path.of(args[0]);

        try{

            List<Interval> intervals = FileReader.read(path);
            System.out.println(Constants.LOADED_FILE + path.getFileName());
            System.out.println(intervals.size() + Constants.RECORDS_LOADED);

        } catch(IOException | IllegalArgumentException e){
            if(e instanceof IOException){
                System.err.println(Constants.COULD_NOT_RETRIEVE_FILE);
            } else{
                System.err.println(Constants.INVALID_FILE_PATH);
            }
            System.exit(1);
        }

        System.out.println("hello world");
    }
}
