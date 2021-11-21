package preprocess;

import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortable;

import java.text.Collator;
import java.util.Locale;

public class Name implements Comparable<Name> {
    public String name;
    public String pinyin;
    long longNum;
    public Name(String name){
        this.name = name;
        this.pinyin = PinYinUtils.toPinYin(this.name);
    }

    public String toString(){
        return this.name;
    }

    private Collator collator = Collator.getInstance(Locale.CHINA);
    @Override
    public int compareTo(Name o) {
        return collator.compare(this.name, o.name);
    }

}
