package com.neu.pojo.impl;

import java.util.Random;

public class Player {
    //玩家名字和积分
    private String name;
    private int credit;

    //用户积分credit setter
    public void setCredit() {
        this.credit++;
    }

    //玩家积分getter
    public int getCredit() {
        return credit;
    }

    //玩家名字fetter
    public String getName() {
        return name;
    }

    //构造方法，参数name为玩家名字，参数credit为玩家积分
    public Player(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    //出拳，返回值1，2，3分别为见到，石头，布
    public int showFist() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
}
