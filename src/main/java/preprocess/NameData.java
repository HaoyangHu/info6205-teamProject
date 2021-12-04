package preprocess;

import java.util.ArrayList;
import java.util.List;

public class NameData {

    public List<Name> names = new ArrayList<>();
    public String[][] namesArray;
    public int len = 0;
    public String[][] getNamesArray(){
        setNames();
        return this.namesArray;
    }
    public void setNames(){
        Initalize.init(names);
        len = names.size();
        namesArray = new String[len][2];
        for(int i = 0; i < len; i++){
            namesArray[i][0] = names.get(i).pinyin;
            namesArray[i][1] = names.get(i).name;
        }
    }

}
