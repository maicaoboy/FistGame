package com.neu.service.impl;

import com.neu.dao.impl.PlayerDao;
import com.neu.service.IGame;

import java.util.Random;

public class Game implements IGame {
    private PlayerDao playerDao;

    public PlayerDao getPlayerDao() {
        return playerDao;
    }
    public void record(int judge) {
        if(judge > 0){
            playerDao.getPlayer().setCredit();
        }
        if(judge < 0) {
            playerDao.getComputer().setCredit();
        }
    }


    public Game(){
        playerDao = new PlayerDao();
    }

    public void reInit() {
        playerDao.initComputerPlayer();
    }

    //出拳，返回值1，2，3分别为见到，石头，布
    public int showFist() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    @Override
    public int judge(int player, int computer) {
        int result = 0;
        if(player == computer){
            result = 0;
        }else if(player == 1) {
            if(computer == 2) {
                result = -1;
            }else {
                result = 1;
            }
        }else if(player == 2) {
            if(computer == 1) {
                result = 1;
            }else {
                result = -1;
            }
        }else{
            if(computer == 1) {
                result = -1;
            }else {
                result = 1;
            }
        }
        return result;
    }
}
