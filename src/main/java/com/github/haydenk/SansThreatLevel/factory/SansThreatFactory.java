package com.github.haydenk.SansThreatLevel.factory;

import com.github.haydenk.SansThreatLevel.model.SansThreat;

public class SansThreatFactory {
    public static SansThreat create(String url, String threatLevel) {
        SansThreat sansThreat = new SansThreat(url, threatLevel);

        switch (sansThreat.getLevel().toLowerCase()) {
            case "green":
                sansThreat
                        .setColor("#9c0")
                        .setDefinition("Everything is normal. No significant new threat known.");
                break;
            case "test":
                sansThreat
                        .setColor("#09c")
                        .setDefinition("This status is used for testing only. Everything is normal. No significant new threat known.");
                break;
            case "yellow":
                sansThreat
                        .setColor("#cc0")
                        .setDefinition("We are currently tracking a significant new threat. The impact is either unknown or expected to be minor to the infrastructure. However, local impact could be significant. Users are advised to take immediate specific action to contain the impact. Example: 'MSBlaster' worm outbreak.");
                break;
            case "orange":
                sansThreat
                        .setColor("#c90")
                        .setDefinition("A major disruption in connectivity is imminent or in progress. Examples: Code Red on its return, and SQL Slammer worm during its first half day");
                break;
            case "red":
                sansThreat
                        .setColor("#c00")
                        .setDefinition("Loss of connectivity across a large part of the internet.");
                break;
        }

        return sansThreat;
    }
}
