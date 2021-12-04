/*
package benchmark.Utils;

import  org.junit.Test;
import preprocess.NameData;

public class ArrayLengthChangeTest {
    @Test
    public void test1(){
        int input = ArrayLengthChange.generateAQuarterOfFiles().length;
        int expected = NameData.len/4;
        assert(input == expected);
    }
    @Test
    public void test2(){
        int input = ArrayLengthChange.generateAHalfOfFiles().length;
        int expected = NameData.len/2;
        assert(input == expected);
    }
    @Test
    public void test3(){
        int input = ArrayLengthChange.generateAFile().length;
        int expected = NameData.len;
        assert(input == expected);
    }
    @Test
    public void test4(){
        int input = ArrayLengthChange.generateDoubleFiles().length;
        int expected = NameData.len*2;
        assert(input == expected);
    }
    @Test
    public void test5(){
        int input = ArrayLengthChange.generateQuadraFiles().length;
        String inputString = ArrayLengthChange.generateQuadraFiles()[NameData.len-1];
        String expectedString1 = ArrayLengthChange.generateQuadraFiles()[NameData.len*2-1];
        String expectedString2 = ArrayLengthChange.generateQuadraFiles()[NameData.len*3-1];
        String expectedString3 = ArrayLengthChange.generateQuadraFiles()[NameData.len*4-1];
        int expected = NameData.len*4;
        assert(input == expected);
        assert (inputString.equals(expectedString1));
        assert (inputString.equals(expectedString2));
        assert (inputString.equals(expectedString3));

    }
}
*/
