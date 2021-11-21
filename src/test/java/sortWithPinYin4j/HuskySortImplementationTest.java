package sortWithPinYin4j;

import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import org.junit.Test;
import preprocess.NameData;

import java.io.IOException;

import static org.junit.Assert.*;

public class HuskySortImplementationTest {

    @Test
    public void test() throws IOException {
        //String[][] test = new String[][]{{"zhang1 san1", "张三"}, {"li3 si4", "李四"}, {"wang2 wu3", "王五"}, {"zhao4 liu4", "赵六"}};
        HuskySortImplementation.Node[] test = new HuskySortImplementation.Node[4];
        Config config = Config.load(HuskySortImplementation.class);
        QuickHuskySort<HuskySortImplementation.Node> sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);

        test[0] = new HuskySortImplementation.Node("zhang1 san1", "张三");
        test[1] = new HuskySortImplementation.Node("li3 si4", "李四");
        test[2] = new HuskySortImplementation.Node("wang2 wu3", "王五");
        test[3] = new HuskySortImplementation.Node("zhao4 liu4", "赵六");
        System.out.println(sorter.getHelper().sorted(sorter.sort(test)));


        assert(test[0].name.equals("李四"));
        assert(test[1].name.equals("王五"));
        assert(test[2].name.equals("张三"));
        assert(test[3].name.equals("赵六"));
    }

}