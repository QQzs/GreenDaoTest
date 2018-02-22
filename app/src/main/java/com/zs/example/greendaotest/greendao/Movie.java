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

    @Id(autoincrement = true)
    private Long id;
    private String name;
    private int year;
    @Generated(hash = 209751824)
    public Movie(Long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }
    @Generated(hash = 1263461133)
    public Movie() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
