package com.askar.webproject;

public class Polyndrome {

    private String word;
    private boolean checked = false;

    public Polyndrome(String word) {
        this.word = word;
    }

    public boolean isPalinDrome() {
        boolean result = false;
        if (checked) {
            result = checked;
        } else {
            int len = word.length();
            for (int i = 0; i < len / 2; i++) {
                if (word.charAt(i) == word.charAt(len - i -1)) {
                    result = true;
                    checked = true;
                } else {
                    checked = false;
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}
