package benchmark.sortWithCollatorBenchmark;

import benchmark.Utils.Benchmark_Timer;
import org.junit.Test;
import sortWithCollator.MSDradixSort;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MSDRadixSortBenchmark {
    @Test
    public void test1(){
        String[] test = new String[]{"张三", "李四", "王五", "赵六"};
        String[] test1 = new String[]{"张七", "李八", "王九", "赵十"};

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("test ", null , (t)-> MSDradixSort.sort(test), null );
        Benchmark_Timer benchmark_timer1 = new Benchmark_Timer("test1 ", null , (t)-> MSDradixSort.sort(test1), null );

        double testTime = benchmark_timer.run(true, 100);
        double testTime1 = benchmark_timer1.run(true,100);

        System.out.println(testTime + "  " + testTime1);
        System.out.println(Arrays.deepToString(test1));

        assertEquals(testTime, testTime1, 15);
    }
}
