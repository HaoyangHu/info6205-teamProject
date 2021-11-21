package preprocess;

import java.util.ArrayList;
import java.util.List;

public class NameData {

    public static List<Name> names = new ArrayList<>();
    public static String[][] namesArray;
    public static int len = 0;

    static{
        if(len == 0){
            setNames();

        }
    }

    public static void setNames(){
        Initalize.init(names);
        len = names.size();
        namesArray = new String[len][2];

        for(int i = 0; i < len; i++){
            namesArray[i][0] = names.get(i).pinyin;
            namesArray[i][1] = names.get(i).name;

        }

    }

}
