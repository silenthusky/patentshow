package com.patentshow.common.error;

/**
 * Created by unclexiao on 2017/12/4.
 */
public class InputNumberNotValid extends RuntimeException {

    private int count;

    public InputNumberNotValid(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
