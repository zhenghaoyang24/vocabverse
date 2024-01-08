package com.zheng.pojo;

public class Example {

    int exapid;
    int wordid;
    String en;
    String cn;
    int heat;
    String adddate;
    String holder;

    int holderid;

    public int getExapid() {
        return exapid;
    }

    public void setExapid(int exapid) {
        this.exapid = exapid;
    }


    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getHolderid() {
        return holderid;
    }

    public void setHolderid(int holderid) {
        this.holderid = holderid;
    }

//    @Override
//    public String toString() {
//        return "Example{" +
//                "exapid=" + exapid +
//                ", wordid=" + wordid +
//                ", en='" + en + '\'' +
//                ", cn='" + cn + '\'' +
//                ", heat=" + heat +
//                ", adddate='" + adddate + '\'' +
//                ", holder='" + holder + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "Example{" +
                "exapid=" + exapid +
                ", wordid=" + wordid +
                ", en='" + en + '\'' +
                ", cn='" + cn + '\'' +
                ", heat=" + heat +
                ", adddate='" + adddate + '\'' +
                ", holder='" + holder + '\'' +
                ", holderid=" + holderid +
                '}';
    }
}
