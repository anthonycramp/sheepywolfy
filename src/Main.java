/*
 * Copyright (c) 2016. Commonwealth of Australia.
 */

import com.google.gson.Gson;
import org.nlogo.headless.HeadlessWorkspace;

public class Main {
	public static void main(String[] args) {
        for (String arg: args) {
            System.out.println(arg);
        }
        Config config = null;
        if (0 == args.length) {
            config = new Config();
        } else {
            config = new Gson().fromJson(args[0], Config.class);
        }

		HeadlessWorkspace workspace = HeadlessWorkspace.newInstance();

		try {
			workspace.open("Wolf Sheep Predation.nlogo");
			workspace.command("set initial-number-sheep " + String.valueOf(config.getInitialNumberOfSheep()));
			workspace.command("set initial-number-wolves " + String.valueOf(config.getInitialNumberOfWolves()));
			workspace.command("set wolf-gain-from-food " + String.valueOf(config.getWolfGainFromFood()));
			workspace.command("set sheep-reproduce " + String.valueOf(config.getSheepReproducePercentageChance()));
			workspace.command("set wolf-reproduce " + String.valueOf(config.getWolfReproducePercentageChange()));
			workspace.command("random-seed 0");
			workspace.command("setup");

			double numberOfSheep = (Double)workspace.report("count sheep");
			double numberOfWolves = (Double)workspace.report("count wolves");
			int counter = 0;
            long startTime = 0;
            long endTime = 0;
            boolean timeout = false;

			while (!timeout && numberOfSheep > 0.0 && numberOfWolves > 0.0 && counter < 1000) {
				++counter;
                startTime = System.currentTimeMillis();
				workspace.command("go");
                endTime = System.currentTimeMillis();
                timeout = endTime - startTime > 100;
				numberOfSheep = (Double)workspace.report("count sheep");
				numberOfWolves = (Double)workspace.report("count wolves");
			}

			System.out.print("After " + counter + " steps, the ");
			if (numberOfSheep <= 0.0) {
				System.out.println("sheep are extinct.");
			} else if (numberOfWolves <= 0.0) {
				System.out.println("wolves are extinct.");
			} else if (timeout) {
                System.out.println("system timed out");
            } else {
				System.out.println("system is stable.");
			}
			workspace.dispose();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}