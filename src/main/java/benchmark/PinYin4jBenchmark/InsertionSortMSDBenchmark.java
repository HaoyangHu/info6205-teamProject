package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import benchmark.Utils.TwoDimensionalArrayLengthChange;
import sortWithPinYin4j.InsertionSortMSD;

import java.util.Arrays;

public class InsertionSortMSDBenchmark {

    public static void main(String[] args) {
//        String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
//        InsertionSortMSD.sort(aQuarterOfNames,0,aQuarterOfNames.length-1,0);
//        System.out.println(Arrays.deepToString(aQuarterOfNames));

//        for (int i = 0; i < 8; i++) {
//            String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
//            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(aQuarterOfNames,0,aQuarterOfNames.length-1,0), null );
//            System.out.println(benchmark_timer.run(true, 100));
//        }
        for (int i = 0; i < 8; i++) {
            String[][] aHalfOfNames = TwoDimensionalArrayLengthChange.generateAHalfOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(aHalfOfNames,0,aHalfOfNames.length-1,0), null );
            System.out.println(benchmark_timer.run(true, 100));
        }

    }

}
