package com.dlex.GolfTournament;

public class NodeGolfer {
    private String id;
    private String firstname;
    private String lastname;
    private int[] scores;
    private NodeGolfer link;

    public NodeGolfer(String id, String firstname, String lastname) {
        int[] insert = {0, 0, 0, 0};
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.scores = insert;
        this.link = null;
    }

    public NodeGolfer(String id, String firstname, String lastname, int[] scores) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.scores = scores;
        this.link = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getScore(int round) {
        return scores[round - 1];
    }

    public void setScore(int round, int score) {
        this.scores[round - 1] = score;
    }

    public NodeGolfer getLink() {
        return link;
    }

    public void setLink(NodeGolfer link) {
        this.link = link;
    }

    public int getAverageScore() {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += scores[i];
        }
        return total;
    }

    @Override
    public String toString() {
        return String.format("%b, %b, %b", this.id, this.firstname, this.lastname);
    }
}
