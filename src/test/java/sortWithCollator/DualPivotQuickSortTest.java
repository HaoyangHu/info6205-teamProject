package sortWithCollator;

import org.junit.Test;

import static org.junit.Assert.*;

public class DualPivotQuickSortTest {

    @Test
    public void test1(){
        String[] test = new String[]{"张三", "李四", "王五", "赵六"};
        DualPivotQuickSort.sort(test);
        assert(test[0].equals("李四"));
        assert(test[1].equals("王五"));
        assert(test[2].equals("张三"));
        assert(test[3].equals("赵六"));
    }
    @Test
    public void test2(){
        String[] test = new String[]{"张三", "詹三", "赵三", "赵六"};
        DualPivotQuickSort.sort(test);
        assert(test[0].equals("詹三"));
        assert(test[1].equals("张三"));
        assert(test[2].equals("赵六"));
        assert(test[3].equals("赵三"));
    }

}