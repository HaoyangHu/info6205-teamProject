package main.java;


public class Name {
    String name;
    String pinyin;

    public Name(){
        this.name = null;
        this.pinyin = null;
    }

    public Name(String name){
        this.name = name;
        this.pinyin = PinYinUtils.toPinYin(this.name);
    }


    public String toString(){
        return this.name;
    }

}
