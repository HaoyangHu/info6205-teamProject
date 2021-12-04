package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;


public class MSDRadixSortBenchmark {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null, (t) -> sortWithPinYin4j.MSDradixSort.sort(250000), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null, (t) -> sortWithPinYin4j.MSDradixSort.sort(500000), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null, (t) -> sortWithPinYin4j.MSDradixSort.sort(1000000), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null, (t) -> sortWithPinYin4j.MSDradixSort.sort(2000000), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null, (t) -> sortWithPinYin4j.MSDradixSort.sort(4000000), null);
            System.out.println(benchmark_timer.run(true, 10));
        }

    }
}
