import java.util.ArrayList;
import java.util.List;

public class NameData {

    static List<Name> names = new ArrayList<>();
    static String[][] namesArray;
    static int len = 0;

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
