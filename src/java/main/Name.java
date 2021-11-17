package main;

public class Name {
    public String name;
    public String pinyin;

    public Name(String name){
        this.name = name;
        this.pinyin = PinYinUtils.toPinYin(this.name);
    }

    public String toString(){
        return this.name;
    }

}
