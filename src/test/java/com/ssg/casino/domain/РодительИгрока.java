package com.ssg.casino.domain;

public class РодительИгрока {

    private int количествоФишек;
    private int сколькоСтавим;
    private RollDiceGame игра;

    public РодительИгрока вИгре(RollDiceGame игра) {
        this.игра = игра;
        return this;
    }

    public РодительИгрока сФишками(int количествоФишек) {
        this.количествоФишек = количествоФишек;
        return this;
    }

    public РодительИгрока делаетСтавку(int сколькоСтавим) {
        this.сколькоСтавим = сколькоСтавим;
        return this;
    }

    public Player родить() throws CasinoGameException {
        Player player = new Player();
        player.joins(игра);
        player.buy(количествоФишек);
        player.bet(new Bet(сколькоСтавим, 1));
        return player;
    }
}
