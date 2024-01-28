package com.zheng.pojo;

public class UserBook {

    int userbookid;
    String userbookname;
    int voccount;
    int holderid;
    String creattime;
    int share;

    String holder;

    String bookdescribe;

    public String getBookdescribe() {
        return bookdescribe;
    }

    public void setBookdescribe(String bookdescribe) {
        this.bookdescribe = bookdescribe;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getUserbookid() {
        return userbookid;
    }

    public void setUserbookid(int userbookid) {
        this.userbookid = userbookid;
    }

    public String getUserbookname() {
        return userbookname;
    }

    public void setUserbookname(String userbookname) {
        this.userbookname = userbookname;
    }

    public int getVoccount() {
        return voccount;
    }

    public void setVoccount(int voccount) {
        this.voccount = voccount;
    }

    public int getHolderid() {
        return holderid;
    }

    public void setHolderid(int holderid) {
        this.holderid = holderid;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "userbookid=" + userbookid +
                ", userbookname='" + userbookname + '\'' +
                ", voccount=" + voccount +
                ", holderid=" + holderid +
                ", creattime='" + creattime + '\'' +
                ", share=" + share +
                ", holder='" + holder + '\'' +
                ", bookdescribe='" + bookdescribe + '\'' +
                '}';
    }
}
