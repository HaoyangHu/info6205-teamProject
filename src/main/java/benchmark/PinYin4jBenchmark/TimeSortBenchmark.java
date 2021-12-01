package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import benchmark.Utils.TwoDimensionalArrayLengthChange;
import sortWithPinYin4j.TimeSort;

import java.util.Arrays;

public class TimeSortBenchmark {
    public static void main(String[] args) {

//        String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
//        TimeSort.sort(aQuarterOfNames);
//        System.out.println(Arrays.deepToString(aQuarterOfNames));

        for (int i = 0; i < 8; i++) {
            String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAHalfOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250k test: ", null , (t)-> sortWithPinYin4j.TimeSort.sort(aQuarterOfNames), null );
            System.out.println(benchmark_timer.run(true, 100));
        }

    }
}
