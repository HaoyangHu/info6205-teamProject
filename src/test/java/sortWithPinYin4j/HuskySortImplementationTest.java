package sortWithPinYin4j;

import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import org.junit.Test;
import preprocess.NameData;

import java.io.IOException;

import static org.junit.Assert.*;

public class HuskySortImplementationTest {

    @Test
    public void test1() throws IOException {
        HuskySortImplementation.Node[] test = new HuskySortImplementation.Node[4];
        Config config = Config.load(HuskySortImplementation.class);
        QuickHuskySort<HuskySortImplementation.Node> sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);

        test[0] = new HuskySortImplementation.Node("zhang1 san1", "张三");
        test[1] = new HuskySortImplementation.Node("li3 si4", "李四");
        test[2] = new HuskySortImplementation.Node("wang2 wu3", "王五");
        test[3] = new HuskySortImplementation.Node("zhao4 liu4", "赵六");
        System.out.println(sorter.getHelper().sorted(sorter.sort(test)));
        assert(test[0].str.equals("li3 si4"));
        assert(test[1].str.equals("wang2 wu3"));
        assert(test[2].str.equals("zhang1 san1"));
        assert(test[3].str.equals("zhao4 liu4"));

    }

    @Test
    public void test2() throws IOException {

        HuskySortImplementation.Node[] test = new HuskySortImplementation.Node[4];
        Config config = Config.load(HuskySortImplementation.class);
        QuickHuskySort<HuskySortImplementation.Node> sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);

        test[0] = new HuskySortImplementation.Node("zhang1 san1", "张三");
        test[1] = new HuskySortImplementation.Node("zhan1 san1", "詹三");
        test[2] = new HuskySortImplementation.Node("zhao4 san1", "赵三");
        test[3] = new HuskySortImplementation.Node("zhao4 liu4", "赵六");
        System.out.println(sorter.getHelper().sorted(sorter.sort(test)));
        assert(test[0].str.equals("zhan1 san1"));
        assert(test[1].str.equals("zhang1 san1"));
        assert(test[2].str.equals("zhao4 liu4"));
        assert(test[3].str.equals("zhao4 san1"));

    }

}