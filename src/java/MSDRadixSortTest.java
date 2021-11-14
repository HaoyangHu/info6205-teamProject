import org.junit.jupiter.api.Test;


public class MSDRadixSortTest {

    @Test
    public void run() {
        String[][] test = new String[][]{
                {"dong1 bei3 da4 xue2", "东北大学" },
                {"bo1 shi1 dun4", "波士顿" },
                {"suan4 fa3", "算法"},
                {"dong1 tian1", "冬天"},
                {"dong1 bei3", "东北"}
        };
        MSDRadixSort.run(test);
        assert(test[0][0].equals("bo1 shi1 dun4"));
        assert(test[1][0].equals("dong1 bei3"));
        assert(test[2][0].equals("dong1 bei3 da4 xue2"));
        assert(test[3][0].equals("dong1 tian1"));
        assert(test[4][0].equals("suan4 fa3"));
    }
}