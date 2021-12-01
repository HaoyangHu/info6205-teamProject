package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import benchmark.Utils.TwoDimensionalArrayLengthChange;
import sortWithPinYin4j.DualPivotQuickSort;

import java.util.Arrays;

public class DualPivotQuickSortBenchmark {

    public static void main(String[] args) {
//        String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
//        DualPivotQuickSort.sort(aQuarterOfNames);
//        System.out.println(Arrays.deepToString(aQuarterOfNames));

        for (int i = 0; i < 8; i++) {
            String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sortWithPinYin4j.DualPivotQuickSort.sort(aQuarterOfNames), null );
            System.out.println(benchmark_timer.run(true, 100));
        }

//        for (int i = 0; i < 8; i++) {
//            DualPivotQuickSort dualPivotQuickSort = new DualPivotQuickSort();
//
//            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null , (t)-> dualPivotQuickSort.sort(), null );
//            System.out.println(benchmark_timer.run(true, 100));
//        }

    }

}
