package sortWithPinYin4j;

import org.junit.Test;

import static org.junit.Assert.*;

public class MSDRadixSortTest {
    @Test
    public void test1(){
        String[][] test = new String[][]{{"zhang1 san1", "张三"}, {"li3 si4", "李四"}, {"wang2 wu3", "王五"}, {"zhao4 liu4", "赵六"}};
        MSDRadixSort.sort(test);
        assert(test[0][0].equals("li3 si4"));
        assert(test[1][0].equals("wang2 wu3"));
        assert(test[2][0].equals("zhang1 san1"));
        assert(test[3][0].equals("zhao4 liu4"));
    }

    @Test
    public void test2(){
        String[][] test = new String[][]{{"zhang1 san1", "张三"}, {"zhan1 san1", "詹三"}, {"zhao4 san1", "赵三"}, {"zhao4 liu4", "赵六"}};
        MSDRadixSort.sort(test);
        assert(test[0][0].equals("zhan1 san1"));
        assert(test[1][0].equals("zhang1 san1"));
        assert(test[2][0].equals("zhao4 liu4"));
        assert(test[3][0].equals("zhao4 san1"));
    }


}