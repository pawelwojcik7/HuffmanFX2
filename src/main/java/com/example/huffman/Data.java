package com.example.huffman;

public class Data {
    private String id;
    private String character;
    private String weight;
    private String probability;
    private String code;

    public Data(String id, String character, String weight, String probability, String code) {
        this.id = id;
        this.character = character;
        this.weight = weight;
        this.probability = probability;
        this.code = code;
    }

    public Data() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
