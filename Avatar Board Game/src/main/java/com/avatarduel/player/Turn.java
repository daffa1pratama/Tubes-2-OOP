package com.avatarduel.player;

public class Turn {
    private Phase phase;
    private int endTurn;

    public Turn(){
        this.phase = Phase.DRAW;
        this.endTurn = 0;
    }

    public Phase getPhase(){return this.phase;}

    public void setPhase(Phase phase){
        this.phase = phase;
    }

    public int getEndTurn(){ return endTurn;}

    public void setEndTurn(int endTurn){ this.endTurn = endTurn;}

    public void changePhase(){
        switch (this.phase){
            case DRAW:
                setPhase(Phase.MAIN1);
                break;
            case MAIN1:
                setPhase(Phase.BATTLE);
                break;
            case BATTLE:
                setPhase(Phase.MAIN2);
                break;
            case MAIN2:
                endTurn = 1;
        }
    }


}
