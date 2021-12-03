package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import org.junit.Test;
import sortWithPinYin4j.HuskySortImplementation;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HuskySortImplementationBenchmarkTest {
    @Test
    public void test1() throws IOException {
        HuskySortImplementation.Node[] test = new HuskySortImplementation.Node[4];
        HuskySortImplementation.Node[] test1 = new HuskySortImplementation.Node[4];
        Config config = Config.load(HuskySortImplementation.class);
        QuickHuskySort<HuskySortImplementation.Node> sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);

        test[0] = new HuskySortImplementation.Node("zhang1 san1", "张三");
        test[1] = new HuskySortImplementation.Node("li3 si4", "李四");
        test[2] = new HuskySortImplementation.Node("wang2 wu3", "王五");
        test[3] = new HuskySortImplementation.Node("zhao4 liu4", "赵六");

        test1[0] = new HuskySortImplementation.Node("zhang1 qi1", "张七");
        test1[1] = new HuskySortImplementation.Node("li3 ba1", "李八");
        test1[2] = new HuskySortImplementation.Node("wang2 jiu3", "王九");
        test1[3] = new HuskySortImplementation.Node("zhao4 shi2", "赵十");
        System.out.println(sorter.getHelper().sorted(sorter.sort(test)));
        System.out.println(sorter.getHelper().sorted(sorter.sort(test1)));

        Benchmark_Timer benchmark_timer = new Benchmark_Timer("test", null , (t)-> sorter.getHelper().sorted(sorter.sort(test)), null );
        Benchmark_Timer benchmark_timer1 = new Benchmark_Timer("test1", null , (t)-> sorter.getHelper().sorted(sorter.sort(test1)), null );

        double testTime = benchmark_timer.run(true, 100);
        double testTime1 = benchmark_timer1.run(true,100);

        System.out.println(testTime + "  " + testTime1);

        assertEquals(testTime, testTime1, 15);
    }
}
