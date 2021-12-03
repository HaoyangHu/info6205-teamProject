package benchmark.sortWithCollatorBenchmark;

import benchmark.Utils.ArrayLengthChange;
import benchmark.Utils.Benchmark_Timer;

public class CollatorLSDSortBenchmark {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            String[] aQuarterOfNames = ArrayLengthChange.generateAQuarterOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sortWithCollator.LSDsort.sort(aQuarterOfNames), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[] aHalfOfNames = ArrayLengthChange.generateAHalfOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null , (t)-> sortWithCollator.LSDsort.sort(aHalfOfNames), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[] Names = ArrayLengthChange.generateAFile();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null , (t)-> sortWithCollator.LSDsort.sort(Names), null );
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[] doubleNames = ArrayLengthChange.generateDoubleFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null , (t)-> sortWithCollator.LSDsort.sort(doubleNames), null );
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[] quadraNames = ArrayLengthChange.generateQuadraFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null , (t)-> sortWithCollator.LSDsort.sort(quadraNames), null );
            System.out.println(benchmark_timer.run(true, 10));
        }

    }
}
