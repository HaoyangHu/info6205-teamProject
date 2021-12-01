package benchmark.PinYin4jBenchmark;

import benchmark.Utils.Benchmark_Timer;
import benchmark.Utils.TwoDimensionalArrayLengthChange;
import edu.neu.coe.huskySort.sort.huskySort.QuickHuskySort;
import edu.neu.coe.huskySort.util.Config;
import preprocess.Name;
import preprocess.NameData;
import sortWithPinYin4j.HuskySortImplementation;

import java.io.IOException;

public class HuskySortImplementationBenchmark {
    static int len;
    static HuskySortImplementation.Node[] nodeNames;
    static Name[] names;
    static QuickHuskySort<HuskySortImplementation.Node> sorter;
    private static Config config;
    public static void init(){
        try {
            config = Config.load(HuskySortImplementation.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sorter = new QuickHuskySort<>(HuskySortImplementation.Node::huskyCode, config);
        len = NameData.len * 2;
        nodeNames = new HuskySortImplementation.Node[len];
        names = new Name[len];
        for(int i = 0; i < len / 2; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i][0], NameData.namesArray[i][1]);
            names[i] = NameData.names.get(i);
        }
        for(int i = len / 2; i < len; i++){
            nodeNames[i] = new HuskySortImplementation.Node(NameData.namesArray[i-len/2][0], NameData.namesArray[i-len/2][1]);
            names[i] = NameData.names.get(i-len/2);
        }
    }


    public static void main(String[] args) throws IOException {

        init();
        System.out.println("begin sorting");


        for (int i = 0; i < 8; i++) {
            Benchmark_Timer benchmark_timer = new Benchmark_Timer(" 2M test: ", null , (t)-> sorter.getHelper().sorted(sorter.sort(nodeNames)), null );
            System.out.println(benchmark_timer.run(true, 100));
        }
//        for (HuskySortImplementation.Node n : nodeNames) {
//            System.out.println(n);
//        }
    }

}
