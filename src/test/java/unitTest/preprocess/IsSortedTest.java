package unitTest.preprocess;

import org.junit.Test;
import preprocess.IsSorted;

import static org.junit.Assert.*;

public class IsSortedTest {

    @Test
    public void StringSorted1(){
        String[][] test = new String[][]{{"a", "1"}, {"b", "2"},{"c", "3"},{"d", "4"}};
        assert(IsSorted.isSorted(test) == true);
    }

    @Test
    public void StringSorted2(){
        String[][] test = new String[][]{{"a", "1"}, {"e", "2"},{"c", "3"},{"d", "4"}};
        assert(IsSorted.isSorted(test) == false);
    }



}