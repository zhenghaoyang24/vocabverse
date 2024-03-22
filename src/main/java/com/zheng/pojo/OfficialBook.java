package com.zheng.pojo;

public class OfficialBook {

    int bookid;
    String bookname;
    int voccount;
    String author;
    String organization;
    String publisher;
    int status;


    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getVoccount() {
        return voccount;
    }

    public void setVoccount(int voccount) {
        this.voccount = voccount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "OfficialBook{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", voccount=" + voccount +
                ", author='" + author + '\'' +
                ", organization='" + organization + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status=" + status +
                '}';
    }
}
