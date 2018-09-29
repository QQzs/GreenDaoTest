package com.zs.example.greendaotest.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zs
 * Date：2018年 09月 29日
 * Time：16:07
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */
@Entity
public class School {

    private String name;
    private String num;
    private String loction;
    @Generated(hash = 794219634)
    public School(String name, String num, String loction) {
        this.name = name;
        this.num = num;
        this.loction = loction;
    }
    @Generated(hash = 1579966795)
    public School() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNum() {
        return this.num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getLoction() {
        return this.loction;
    }
    public void setLoction(String loction) {
        this.loction = loction;
    }

}
