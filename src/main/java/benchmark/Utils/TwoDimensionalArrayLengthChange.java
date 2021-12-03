package benchmark.Utils;

import preprocess.NameData;

public class TwoDimensionalArrayLengthChange {

    public static String[][] generateAQuarterOfFiles(){
        String[][] aQuarterOfNames;
        int len = NameData.len / 4;
        aQuarterOfNames = new String[len][2];
        for(int i = 0; i < len; i++){
            aQuarterOfNames[i][0] = NameData.namesArray[i][0];
            aQuarterOfNames[i][1] = NameData.namesArray[i][1];
        }
        return aQuarterOfNames;
    }

    public static String[][] generateAHalfOfFiles(){
        int len = NameData.len / 2;
        String[][] AHalfOfNames = new String[len][2];
        for(int i = 0; i < len; i++){
            AHalfOfNames[i][0] = NameData.namesArray[i][0];
            AHalfOfNames[i][1] = NameData.namesArray[i][1];
        }
        return AHalfOfNames;
    }

    public static String[][] generateAFile(){
        int len = NameData.len;
        String[][] Names = new String[len][2];
        for(int i = 0; i < len; i++){
            Names[i][0] = NameData.namesArray[i][0];
            Names[i][1] = NameData.namesArray[i][1];
        }
        return Names;
    }

    public static String[][] generateDoubleFiles(){
        int len = NameData.len * 2;
        String[][] DoubleNames = new String[len][2];
        for(int i = 0; i < len / 2; i++){
            DoubleNames[i][0] = NameData.namesArray[i][0];
            DoubleNames[i][1] = NameData.namesArray[i][1];
        }
        for(int i = len / 2; i < len; i++){
            DoubleNames[i][0] = NameData.namesArray[i - (len / 2)][0];
            DoubleNames[i][1] = NameData.namesArray[i - (len / 2)][1];
        }
        return DoubleNames;
    }

    public static String[][] generateQuadraFiles(){
        int len = NameData.len * 4;
        String[][] quadraNames = new String[len][2];
        for(int i = 0; i < len / 4; i++){
            quadraNames[i][0] = NameData.namesArray[i][0];
            quadraNames[i][1] = NameData.namesArray[i][1];
        }
        for(int i = len / 4; i < len / 2; i++){
            quadraNames[i][0] = NameData.namesArray[i - (len / 4)][0];
            quadraNames[i][1] = NameData.namesArray[i - (len / 4)][1];
        }
        for(int i = len / 2; i < len * 3 / 4; i++){
            quadraNames[i][0] = NameData.namesArray[i - (len / 2)][0];
            quadraNames[i][1] = NameData.namesArray[i - (len / 2)][1];
        }
        for(int i = len * 3 / 4; i < len; i++){
            quadraNames[i][0] = NameData.namesArray[i - (len * 3 / 4)][0];
            quadraNames[i][1] = NameData.namesArray[i - (len * 3 / 4)][1];
        }
        return quadraNames;
    }


}

