package com.codegym.model;

public class Mailbox {
    private String language;
    private int size;
    private boolean spams;
    private String signature;

    public Mailbox(String language, int size, boolean spams, String signature) {
        this.language = language;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public Mailbox() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
