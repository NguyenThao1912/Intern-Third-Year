package com.example.drivinglicense.model;

public class Question {
    //private int Z_PK;
    private String ZQUESTIONCONTENT;
    private String ZIMGAE;
    private String ZOPTION1;
    private String ZOPTION2;
    private String ZOPTION3;
    private String ZOPTION4;
    private int ZANSWERDESC;
    private int ZANSWERS;
    private String ZQUESTIONDIE;
    private String ZAWSA1;
/*
    private int ZQUESTIONTYPE;
    private int ZLEARNED;
    private int ZMARKED;
    private int ZWRONG;
    private int ZINCLUDEA1;
    private int ZINCLUDEA2;
    private int ZINCLUDEA34;
    private int ZINCLUDEB1;
    private int ZINCLUDEB2;
    private int ZINCLUDEC;
    private int ZINCLUDEDEF;
    private int Z_ENT;
*/
    public Question() {
    }

    public String getZQUESTIONCONTENT() {
        return ZQUESTIONCONTENT;
    }

    public void setZQUESTIONCONTENT(String ZQUESTIONCONTENT) {
        this.ZQUESTIONCONTENT = ZQUESTIONCONTENT;
    }

    public String getZIMGAE() {
        return ZIMGAE;
    }

    public void setZIMGAE(String ZIMGAE) {
        this.ZIMGAE = ZIMGAE;
    }

    public String getZOPTION1() {
        return ZOPTION1;
    }

    public void setZOPTION1(String ZOPTION1) {
        this.ZOPTION1 = ZOPTION1;
    }

    public String getZOPTION2() {
        return ZOPTION2;
    }

    public void setZOPTION2(String ZOPTION2) {
        this.ZOPTION2 = ZOPTION2;
    }

    public String getZOPTION3() {
        return ZOPTION3;
    }

    public void setZOPTION3(String ZOPTION3) {
        this.ZOPTION3 = ZOPTION3;
    }

    public String getZOPTION4() {
        return ZOPTION4;
    }

    public void setZOPTION4(String ZOPTION4) {
        this.ZOPTION4 = ZOPTION4;
    }

    public int getZANSWERDESC() {
        return ZANSWERDESC;
    }

    public void setZANSWERDESC(int ZANSWERDESC) {
        this.ZANSWERDESC = ZANSWERDESC;
    }

    public int getZANSWERS() {
        return ZANSWERS;
    }

    public void setZANSWERS(int ZANSWERS) {
        this.ZANSWERS = ZANSWERS;
    }

    public String getZQUESTIONDIE() {
        return ZQUESTIONDIE;
    }

    public void setZQUESTIONDIE(String ZQUESTIONDIE) {
        this.ZQUESTIONDIE = ZQUESTIONDIE;
    }

    public String getZAWSA1() {
        return ZAWSA1;
    }

    public void setZAWSA1(String ZAWSA1) {
        this.ZAWSA1 = ZAWSA1;
    }

    public Question(String ZQUESTIONCONTENT, String ZIMGAE, String ZOPTION1, String ZOPTION2, String ZOPTION3, String ZOPTION4, int ZANSWERDESC, int ZANSWERS, String ZQUESTIONDIE, String ZAWSA1) {
        this.ZQUESTIONCONTENT = ZQUESTIONCONTENT;
        this.ZIMGAE = ZIMGAE;
        this.ZOPTION1 = ZOPTION1;
        this.ZOPTION2 = ZOPTION2;
        this.ZOPTION3 = ZOPTION3;
        this.ZOPTION4 = ZOPTION4;
        this.ZANSWERDESC = ZANSWERDESC;
        this.ZANSWERS = ZANSWERS;
        this.ZQUESTIONDIE = ZQUESTIONDIE;
        this.ZAWSA1 = ZAWSA1;
    }
}
