package com.neu.dao.impl;

import com.neu.dao.IPlayerDao;
import com.neu.pojo.impl.Player;

public class PlayerDao implements IPlayerDao {
    Player[] computerList;
    Player player;
    Player computer;

    public PlayerDao() {
        initComputerPlayer();
    }

    public void setComputer(Player computer) {
        this.computer = computer;
    }

    public Player getComputer() {
        return computer;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void initComputerPlayer() {
        computerList = new Player[3];
        computerList[0] = new Player("刘备",0);
        computerList[1] = new Player("孙权",0);
        computerList[2] = new Player("曹操",0);
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }


    @Override
    public Player getComputerPlayer(int num) {
        return computerList[num - 1];
    }

}
