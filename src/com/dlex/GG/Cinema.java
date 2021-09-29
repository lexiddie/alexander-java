package com.dlex.GG;

public class Cinema {

    private final int cinemaNumber;
    private Movie movie;

    public Cinema(int cinemaNumber, String name, String type, String startTime, int totalTime) {
        this.cinemaNumber = cinemaNumber;
        this.movie = new Movie(name, type, startTime, totalTime);
    }

    public int getCinemaNumber() {
        return cinemaNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMovieName() {
        return this.movie.getName();
    }

    public String getMovieType() {
        return this.movie.getType();
    }

    public String getMovieStartTime() {
        return this.movie.getStartTime();
    }

    public int getMovieTotalTime() {
        return this.movie.getTotalTime();
    }

}
