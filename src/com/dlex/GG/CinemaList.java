package com.dlex.GG;

public class CinemaList {

    private Node head;

    public CinemaList() {
        this.head = null;
    }

    public boolean insert(Cinema cinema) {
        Node newNode = new Node(cinema);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(newNode);
        }
        return true;
    }

    public int countAllBookedSeats() {
        int counter = 0;
        Node current = head;
        while (current != null) {
            counter += current.getCinema().getMovie().countBookedSeats();
            current = current.getLink();
        }
        return counter;
    }

    public boolean bookingSeat(int index, int row, int seat) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count == index) {
                current.getCinema().getMovie().bookSeat(row, seat);
                return true;
            }
            current = current.getLink();
            count++;
        }
        return false;
    }

    public boolean checkSeat(int index, int row, int seat) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (count == index) {
                current.getCinema().getMovie().checkSeat(row, seat);
                return true;
            }
            current = current.getLink();
            count++;
        }
        return false;
    }

    public void showAllCinema() {
        Node current = head;
        while (current != null) {
            String labelCinema = String.format("%15s", "Cinema: ");
            String labelName = String.format("%15s", "Movie name: ");
            String labelType = String.format("%10s", "Genre: ");
            String labelStartTime = String.format("%15s", "Start time: ");
            String labelTotalTime = String.format("%15s", "Total time ");
            String temp = labelCinema + current.getCinema().getCinemaNumber() + labelName + current.getCinema().getMovieName() + labelType + current.getCinema().getMovieType() + labelStartTime + current.getCinema().getMovieStartTime() + labelTotalTime + current.getCinema().getMovieTotalTime();
            System.out.println(temp);
            current = current.getLink();
        }
    }

    public int count() {
        int counter = 0;
        Node current = head;
        while (current != null) {
            current = current.getLink();
            counter++;
        }
        return counter;
    }

    private boolean isEmpty() {
        return (head == null);
    }
}
