package com.bwie.lifengzhuang20170717;

/**
 * 类描述：
 * 创建人：李冯壮
 * 创建时间：2017/7/17 9:31
 */
public class User {
    private boolean isChecked;
    private int iamge;
    private int price;

    public User(boolean isChecked, int iamge, int price) {
        this.isChecked = isChecked;
        this.iamge = iamge;
        this.price = price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getIamge() {
        return iamge;
    }

    public void setIamge(int iamge) {
        this.iamge = iamge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
