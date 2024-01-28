package com.zheng.pojo;

public class SearchWordHistory {
    int wordid;
    String spelling;
    int userid;

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "SearchWordHistory{" +
                "wordid=" + wordid +
                ", spelling='" + spelling + '\'' +
                ", userid=" + userid +
                '}';
    }
}
