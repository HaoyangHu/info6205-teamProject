import org.junit.jupiter.api.Test;


public class MSDRadixSortTest {

    @Test
    public void run() {
        String[][] test = new String[][]{
                {"dong1 bei3 da4 xue2", "东北大学" },
                {"bo1 shi1 dun4", "波士顿" },
                {"suan4 fa3", "算法"},
                {"dong1 tian1", "冬天"},
                {"dong1 bei3", "东北"},
                {"gong1 yu4", "公寓"},
                {"shui3 bei1", "水杯"},
                {"dian4 nao3", "电脑"},
                {"ping2 guo3", "苹果"},
                {"jian4 pan2", "键盘"},
                {"er3 ji1", "耳机"},
                {"ping2 ban3 dian4 nao3", "平板电脑"},
                {"xian3 shi4 qi4", "显示器"},
                {"shou3 ji1", "手机"},
                {"zhi3 xiang1 zi3", "纸箱子"},
                {"chuang2 tou2 gui4", "床头柜"},
                {"yin1 xiang3", "音响"},
        };
        String[][] ans = new String[][]{
                {"bo1 shi1 dun4", "波士顿"},
                {"chuang2 tou2 gui4", "床头柜"},
                {"dian4 nao3", "电脑"},
                {"dong1 bei3", "东北"},
                {"dong1 bei3 da4 xue2", " 东北大学"},
                {"dong1 tian1", "冬天"},
                {"er3 ji1", "耳机"},
                {"gong1 yu4", "公寓"},
                {"jian4 pan2", "键盘"},
                {"ping2 ban3 dian4 nao3", "平板电脑"},
                {"ping2 guo3", "苹果"},
                {"shou3 ji1", "手机"},
                {"shui3 bei1", "水杯"},
                {"suan4 fa3", "算法"},
                {"xian3 shi4 qi4", "显示器"},
                {"yin1 xiang3", "音响"},
                {"zhi3 xiang1 zi3", "纸箱子"},

        };
        MSDRadixSort.run(test);
        for(int i = 0; i < test.length; i++){
            assert (test[i][0].equals(ans[i][0]));
        }
    }

    @Test
    public void insertionTest(){
        String[][] test = new String[][]{
                {"dong1 bei3 da4 xue2", "东北大学" },
                {"bo1 shi1 dun4", "波士顿" },
                {"suan4 fa3", "算法"},
                {"dong1 tian1", "冬天"},
                {"dong1 bei3", "东北"}
        };
        InsertionSortMSD.sort(test, 0, 4, 0);
        assert(test[0][0].equals("bo1 shi1 dun4"));
        assert(test[1][0].equals("dong1 bei3"));
        assert(test[2][0].equals("dong1 bei3 da4 xue2"));
        assert(test[3][0].equals("dong1 tian1"));
        assert(test[4][0].equals("suan4 fa3"));

    }


}