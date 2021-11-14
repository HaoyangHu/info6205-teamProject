import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void run(){
        String name = "刘德华";
        Name test1 = new Name(name);
        assert(test1.pinyin.equals("liu2 de2 hua2"));
        name = "成龙";
        Name test2 = new Name(name);
        assert(test2.pinyin.equals("cheng2 long2"));
        name = "迪丽热巴";
        Name test3 = new Name(name);
        assert(test3.pinyin.equals("di2 li4 re4 ba1"));
    }

}