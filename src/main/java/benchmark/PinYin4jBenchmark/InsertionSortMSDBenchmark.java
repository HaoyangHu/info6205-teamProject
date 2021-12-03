package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import benchmark.Utils.TwoDimensionalArrayLengthChange;


public class InsertionSortMSDBenchmark {

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            String[][] aQuarterOfNames = TwoDimensionalArrayLengthChange.generateAQuarterOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 250K test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(aQuarterOfNames,0,aQuarterOfNames.length-1,0), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[][] aHalfOfNames = TwoDimensionalArrayLengthChange.generateAHalfOfFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 500K test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(aHalfOfNames,0,aHalfOfNames.length-1,0), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[][] Names = TwoDimensionalArrayLengthChange.generateAFile();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 1M test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(Names,0, Names.length-1, 0), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[][] doubleNames = TwoDimensionalArrayLengthChange.generateDoubleFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(doubleNames,0, doubleNames.length-1, 0), null );
            System.out.println(benchmark_timer.run(true, 10));
        }
        for (int i = 0; i < 8; i++) {
            String[][] quadraNames = TwoDimensionalArrayLengthChange.generateQuadraFiles();
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 4M test: ", null , (t)-> sortWithPinYin4j.InsertionSortMSD.sort(quadraNames,0, quadraNames.length-1, 0), null );
            System.out.println(benchmark_timer.run(true, 10));
        }

    }

}
