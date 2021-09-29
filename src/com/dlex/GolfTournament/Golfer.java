package com.dlex.GolfTournament;

public class Golfer {
    private NodeGolfer head;
    private NodeGolfer update;

    public Golfer() {
        head = null;
    }

    public boolean insertGolfer(String id, String firstname, String lastname) {
        NodeGolfer newNode = new NodeGolfer(id, firstname, lastname);
        if (isEmpty()) {
            head = newNode;
            return true;
        } else {
            int compareHead = head.getLastname().compareTo(lastname);
            if (compareHead > 0) {
                newNode.setLink(head);
                head = newNode;
            } else {
                NodeGolfer current = head.getLink();
                NodeGolfer previous = head;
                int compare = current.getLastname().compareTo(lastname);
                while (current != null && compare > 0) {
                    previous = current;
                    current = current.getLink();
                }
                newNode.setLink(current);
                previous.setLink(newNode);
            }
            return true;
        }
    }

    public void insertGolfer(NodeGolfer load) {
        if (isEmpty()) {
            head = load;
        } else {
            NodeGolfer current = head;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(load);
        }
    }

    public boolean updateScores(int round, int score) {
        update.setScore(round, score);
        return true;
    }

    public int find(String id) {
        int index = 0;
        NodeGolfer current = head;
        update = current;
        while (current != null) {
            if (current.getId().equals(id)) {
                return index;
            } else {
                current = current.getLink();
            }
            index++;
        }
        return -1;
    }

    public boolean delete(String id) {
        NodeGolfer current = head;
        NodeGolfer previous = null;
        while (current != null) {
            if (head.getId().equals(id)) {
                head = current.getLink();
                return true;
            } else if (current.getId().equals(id)) {
                previous.setLink(current.getLink());
                return true;
            } else {
                previous = current;
                current = current.getLink();
            }
        }
        return false;
    }

    public int count() {
        int counter = 0;
        NodeGolfer current = head;
        while (current != null) {
            current = current.getLink();
            counter++;
        }
        return counter;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public NodeGolfer getHead() {
        return head;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        NodeGolfer current = head;
        while (current != null) {
            String name = String.format("%15s, %15s", current.getFirstname(), current.getLastname());
            result.append(name + "\n");
            current = current.getLink();
        }
        return result.toString();
    }
}
