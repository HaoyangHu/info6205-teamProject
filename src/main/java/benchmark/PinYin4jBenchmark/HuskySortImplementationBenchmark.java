package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import preprocess.Name;
import preprocess.NameData;
import sortWithPinYin4j.HuskySortImplementation;

import java.io.IOException;

public class HuskySortImplementationBenchmark {


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {

            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> HuskySortImplementation.sort(250000), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null , (t)-> HuskySortImplementation.sort(500000), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null , (t)-> HuskySortImplementation.sort(1000000), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null , (t)-> HuskySortImplementation.sort(2000000), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null , (t)-> HuskySortImplementation.sort(4000000), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
    }

}
