package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import org.junit.Test;
import sortWithPinYin4j.MSDradixSort;
import sortWithPinYin4j.ThreeWayStringQuicksort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MSDRadixSortBenchmarkTest {
    @Test
    public void test1(){
        String[][] test = new String[][]{{"zhang1 san1", "张三"}, {"li3 si4", "李四"}, {"wang2 wu3", "王五"}, {"zhao4 liu4", "赵六"}};
        String[][] test1 = new String[][]{{"zhang1 qi1", "张七"}, {"li3 ba1", "李八"}, {"wang2 jiu3", "王九"}, {"zhao4 shi2", "赵十"}};

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("test ", null , (t)-> MSDradixSort.sort(test), null );
        Benchmark_Timer benchmark_timer1 = new Benchmark_Timer("test1 ", null , (t)-> MSDradixSort.sort(test1), null );

        double testTime = benchmark_timer.run(true, 100);
        double testTime1 = benchmark_timer1.run(true,100);

        System.out.println(testTime + "  " + testTime1);
        System.out.println(Arrays.deepToString(test1));

        assertEquals(testTime, testTime1, 15);
    }
}
