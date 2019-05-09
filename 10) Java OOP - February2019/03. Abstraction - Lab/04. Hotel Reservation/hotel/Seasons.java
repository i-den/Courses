package hotel;

public enum Seasons {
    Autumn(1),
    Spring(2),
    Winter(3),
    Summer(4);

    private int seasonMultiplier;

    Seasons(int seasonMultiplier) {
        this.seasonMultiplier = seasonMultiplier;
    }

    public int getSeasonMultiplier() {
        return seasonMultiplier;
    }
}
