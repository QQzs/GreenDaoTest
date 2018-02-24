package com.zs.example.greendaotest.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by zs
 * Date：2018年 02月 22日
 * Time：14:21
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */
@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private int age;
    private boolean isBoy;
    @Generated(hash = 1724489812)
    public User(Long id, String name, int age, boolean isBoy) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isBoy = isBoy;
    }
    @Generated(hash = 586692638)
    public User() {
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
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean getIsBoy() {
        return this.isBoy;
    }
    public void setIsBoy(boolean isBoy) {
        this.isBoy = isBoy;
    }
}
