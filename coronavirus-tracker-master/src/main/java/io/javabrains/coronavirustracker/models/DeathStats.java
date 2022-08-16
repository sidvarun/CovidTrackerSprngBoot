package io.javabrains.coronavirustracker.models;

public class DeathStats {
    private String state;
    private String country;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalDeaths() {
        return latestTotalDeaths;
    }

    public void setLatestTotalDeaths(int latestTotalDeaths) {
        this.latestTotalDeaths = latestTotalDeaths;
    }

    public int getDiffDeathsFromPrevDay() {
        return diffDeathsFromPrevDay;
    }

    public void setDiffDeathsFromPrevDay(int diffDeathsFromPrevDay) {
        this.diffDeathsFromPrevDay = diffDeathsFromPrevDay;
    }

    private int latestTotalDeaths;

    @Override
    public String toString() {
        return "DeathStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalDeaths=" + latestTotalDeaths +
                ", diffDeathsFromPrevDay=" + diffDeathsFromPrevDay +
                '}';
    }

    private int diffDeathsFromPrevDay;
}
