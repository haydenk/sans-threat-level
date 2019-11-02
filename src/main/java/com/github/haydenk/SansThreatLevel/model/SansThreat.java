package com.github.haydenk.SansThreatLevel.model;

public class SansThreat {
    private String url;
    private String level;
    private String color;
    private String definition;

    public SansThreat(String url, String level) {
        this.url = url;
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public String getLevel() {
        return level;
    }

    public SansThreat setColor(String color) {
        this.color = color;
        return this;
    }

    public String getColor() {
        return color;
    }

    public SansThreat setDefinition(String definition) {
        this.definition = definition;
        return this;
    }

    public String getDefinition() {
        return definition;
    }
}
