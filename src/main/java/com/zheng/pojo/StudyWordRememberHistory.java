package com.zheng.pojo;

public class StudyWordRememberHistory {
    int userid;
    int wordid;
    int opt;
    String selectdate;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getWordid() {
        return wordid;
    }

    public void setWordid(int wordid) {
        this.wordid = wordid;
    }

    public int getOpt() {
        return opt;
    }

    public void setOpt(int opt) {
        this.opt = opt;
    }

    public String getSelectdate() {
        return selectdate;
    }

    public void setSelectdate(String selectdate) {
        this.selectdate = selectdate;
    }

    @Override
    public String toString() {
        return "StudyWordRememberHistory{" +
                "userid=" + userid +
                ", wordid=" + wordid +
                ", opt=" + opt +
                ", selectdate='" + selectdate + '\'' +
                '}';
    }
}
