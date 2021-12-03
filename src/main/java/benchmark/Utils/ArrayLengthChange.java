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

    public static String[] generateAHalfOfFiles(){
        String[] aHalfOfNames;
        int len = NameData.len / 2;
        aHalfOfNames = new String[len];
        for(int i = 0; i < len; i++){
            aHalfOfNames[i] = NameData.namesArray[i][1];
        }
        return aHalfOfNames;
    }

    public static String[] generateAFile(){
        String[] Names;
        int len = NameData.len;
        Names = new String[len];
        for(int i = 0; i < len; i++){
            Names[i] = NameData.namesArray[i][1];
        }
        return Names;
    }

    public static String[] generateDoubleFiles(){
        String[] doubleNames;
        int len = NameData.len * 2;
        doubleNames = new String[len];
        for(int i = 0; i < len/2; i++){
            doubleNames[i] = NameData.namesArray[i][1];
        }
        for(int i = len/2; i < len; i++){
            doubleNames[i] = NameData.namesArray[i - len/2][1];
        }
        return doubleNames;
    }

    public static String[] generateQuadraFiles(){
        String[] quadraNames;
        int len = NameData.len * 4;
        quadraNames = new String[len];
        for(int i = 0; i < len/4; i++){
            quadraNames[i] = NameData.namesArray[i][1];
        }
        for(int i = len/4; i < len/2; i++){
            quadraNames[i] = NameData.namesArray[i - len/4][1];
        }
        for(int i = len/2; i < len*3/4; i++){
            quadraNames[i] = NameData.namesArray[i - len/2][1];
        }
        for(int i = len*3/4; i < len; i++){
            quadraNames[i] = NameData.namesArray[i - len*3/4][1];
        }
        return quadraNames;
    }

}
