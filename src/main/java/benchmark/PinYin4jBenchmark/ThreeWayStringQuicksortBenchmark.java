package benchmark.PinYin4jBenchmark;

import benchmark.Utils.TwoDimensionalArrayLengthChange;
import benchmark.Utils.Benchmark_Timer;
import sortWithPinYin4j.ThreeWayStringQuicksort;

public class ThreeWayStringQuicksortBenchmark {


    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            ThreeWayStringQuicksort.init();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null, (t) -> ThreeWayStringQuicksort.sort(), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null, (t) -> ThreeWayStringQuicksort.sort(aQuarterOfNames), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[][] aHalfOfNames = TwoDimensionalArrayLengthChange.generateAHalfOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null, (t) -> ThreeWayStringQuicksort.sort(aHalfOfNames), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[][] doubleNames = TwoDimensionalArrayLengthChange.generateDoubleFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null, (t) -> ThreeWayStringQuicksort.sort(doubleNames), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            String[][] quadraNames = TwoDimensionalArrayLengthChange.generateQuadraFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null, (t) -> ThreeWayStringQuicksort.sort(quadraNames), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

    }
}

