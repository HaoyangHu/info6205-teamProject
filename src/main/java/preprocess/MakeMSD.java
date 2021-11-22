package preprocess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MakeMSD {

    static class Word{
        char word;
        String pinyin;

        public Word(char word){
            this.word = word;
            this.pinyin = PinYinUtils.toPinYin(String.valueOf(this.word));
        }
    }

    public static Map<Character, Integer> getMap(){
        init();
        return order;
    }

    static Word[] words;
    static Map<Character, Integer> order;
    static Set<Character> set;

    public static void init(){
        set = new HashSet<>();
        initSet();
        initWords();
        Arrays.sort(words, (o1, o2) -> o1.pinyin.compareTo(o2.pinyin));
        order = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            //System.out.println(words[i].word);
            order.put(words[i].word, i);
        }
    }

    public static void main(String[] args) {
        init();
        System.out.println(order.size());

        System.out.println(order.get('社'));
        //System.out.println(order.get("刘") + " " + order.get("梅"));
    }


    public static void initWords(){
        words = new Word[set.size()];
        int p = 0;
        for(char c : set){
            words[p++] = new Word(c);
        }
    }

    public static void initSet(){
        //int count = 0;
        try(BufferedReader inLine = new BufferedReader(new FileReader("src/main/resources/shuffledChinese.txt"))){
            String in = null;
            while((in = inLine.readLine()) != null) {
                char[] temp = in.toCharArray();
                //count++;
                for(char c : temp){

                    set.add(c);
                }
                //if(count == 100) return;
            }
        }catch(Exception e) {
            System.out.println("Caught an ERROR!");
            e.printStackTrace();
        }

    }
}
