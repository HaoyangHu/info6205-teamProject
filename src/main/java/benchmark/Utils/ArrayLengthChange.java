package benchmark.Utils;

import preprocess.NameData;

public class ArrayLengthChange {
    public static String[] generateAQuarterOfFiles(){
        String[] aQuarterOfNames;
        int len = NameData.len / 4;
        aQuarterOfNames = new String[len];
        for(int i = 0; i < len; i++){
            aQuarterOfNames[i] = NameData.names.get(i).name;
        }
        return aQuarterOfNames;
    }

}
