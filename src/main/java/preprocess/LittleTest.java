package preprocess;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class LittleTest {
    public static void main(String[] args) {
        Name[] names = new Name[2];
        names[0] = new Name("瞿麟曼");
        names[1] = new Name("张");
        Collator collator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(names,  (o1, o2) -> collator.compare(o1.name, o2.name));
        for(Name n : names){
            System.out.println(n);
        }
    }
}
