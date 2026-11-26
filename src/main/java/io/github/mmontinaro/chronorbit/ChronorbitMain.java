package io.github.mmontinaro.chronorbit;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import io.github.mmontinaro.chronorbit.common.Constants;
import io.github.mmontinaro.chronorbit.io.FileReader;
import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.model.Solution;
import io.github.mmontinaro.chronorbit.service.Formatter;
import io.github.mmontinaro.chronorbit.service.SweepLine;

public class ChronorbitMain {
    public static void main(String[] args) {

        if(args.length != 1){
            System.err.println(Constants.ARG_NUM_INVALID);
            System.exit(1);
        }

        try{
            Path path = Path.of(args[0]);
            FileReader.checkPathExists(path);
            List<Interval> intervals = FileReader.read(path);
            System.out.println(Constants.LOADED_FILE + path.getFileName());
            System.out.println(intervals.size() + " " + Constants.RECORDS_LOADED);
            SweepLine sweepLine = new SweepLine();
            Formatter formatter = new Formatter();
            List<Solution> solutions = sweepLine.sweepLine(intervals);
            solutions.stream().forEach(s -> System.out.println(formatter.format(s)));
            System.exit(0);
        } catch(IOException e){
            System.err.println(Constants.COULD_NOT_RETRIEVE_FILE);
            System.exit(1);
        } catch (IllegalArgumentException e){
            System.err.println(Constants.INVALID_FILE_PATH);
            System.exit(1);
        } 
    }
}
