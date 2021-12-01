package benchmark.sortWithCollatorBenchmark;

import benchmark.Utils.ArrayLengthChange;
import benchmark.Utils.Benchmark_Timer;
import sortWithCollator.DualPivotQuickSort;

import java.util.Arrays;

public class DualPivotQuickSortBenchmark {
    public static void main(String[] args) {

//        String[] aQuarterOfNames = ArrayLengthChange.generateAQuarterOfFiles();
//        DualPivotQuickSort.sort(aQuarterOfNames);
//        System.out.println(Arrays.deepToString(aQuarterOfNames));

        for (int i = 0; i < 8; i++) {
            String[] aQuarterOfNames = ArrayLengthChange.generateAQuarterOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sortWithCollator.DualPivotQuickSort.sort(aQuarterOfNames), null );
            System.out.println(benchmark_timer.run(true, 100));
       }
    }
}
