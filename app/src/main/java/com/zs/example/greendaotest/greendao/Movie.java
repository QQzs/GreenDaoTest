package com.zs.example.greendaotest.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zs
 * Date：2018年 02月 22日
 * Time：15:35
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */
@Entity
public class Movie {

    @Id
    private String name;
    private int year;
    @Generated(hash = 1431039700)
    public Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }
    @Generated(hash = 1263461133)
    public Movie() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
