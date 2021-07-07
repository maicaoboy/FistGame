package com.neu.dao;

import com.neu.pojo.impl.Player;

public interface IPlayerDao {
    public void setPlayer(Player player);
    public void initComputerPlayer();
    public Player getPlayer();
    public Player getComputerPlayer(int num);
}
