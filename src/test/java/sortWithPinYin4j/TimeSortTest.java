package sortWithPinYin4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeSortTest {
    @Test
    public void test(){
        String[][] test = new String[][]{{"zhang1 san1", "张三"}, {"li3 si4", "李四"}, {"wang2 wu3", "王五"}, {"zhao4 liu4", "赵六"}};
        TimeSort.sort(test);
        assert(test[0][1].equals("李四"));
        assert(test[1][1].equals("王五"));
        assert(test[2][1].equals("张三"));
        assert(test[3][1].equals("赵六"));
    }
}