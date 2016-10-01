/*
 * Copyright (c) 2016. Commonwealth of Australia.
 */

/**
 * Created by crampy on 29/09/2016.
 */
public class Config {
    private int initialNumberOfSheep = 100;
    private int initialNumberOfWolves = 50;
    private int wolfGainFromFood = 15;
    private int sheepReproducePercentageChance = 3;
    private int wolfReproducePercentageChange = 5;

    public int getInitialNumberOfSheep() {
        return this.initialNumberOfSheep;
    }

    public int getInitialNumberOfWolves() {
        return this.initialNumberOfWolves;
    }

    public int getWolfGainFromFood() {
        return this.wolfGainFromFood;
    }

    public int getSheepReproducePercentageChance() {
        return this.sheepReproducePercentageChance;
    }

    public int getWolfReproducePercentageChange() {
        return this.wolfReproducePercentageChange;
    }

    Config() {

    }
}
