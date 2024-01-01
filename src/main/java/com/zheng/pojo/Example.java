package com.zheng.pojo;

public class Example {

    int exapid;
    int wordid;
    String en;
    String cn;
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

    public int getHolderid() {
        return holderid;
    }

    public void setHolderid(int holderid) {
        this.holderid = holderid;
    }

    @Override
    public String toString() {
        return "Exmaple{" +
                "exapid=" + exapid +
                ", wordid=" + wordid +
                ", en='" + en + '\'' +
                ", cn='" + cn + '\'' +
                ", holderid=" + holderid +
                '}';
    }
}
