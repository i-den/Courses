package hotel;

public class PriceCalculator {

    PriceCalculator() {
    }

    ;

    public double calculate(double pricePerDay, int numberOfDays, String season, String discountType) {
        return pricePerDay * numberOfDays * getSeasonalMultiplier(season) * getDiscountedMultiplier(discountType);
    }

    private int getSeasonalMultiplier(String season) {
        switch (season) {
            case "Autumn":
                return Seasons.Autumn.getSeasonMultiplier();
            case "Spring":
                return Seasons.Spring.getSeasonMultiplier();
            case "Winter":
                return Seasons.Winter.getSeasonMultiplier();
            case "Summer":
            default:
                return Seasons.Summer.getSeasonMultiplier();
        }
    }

    private double getDiscountedMultiplier(String discountType) {
        switch (discountType) {
            case "None":
                return (100 - ClientGroupDiscount.Normal.getDiscountPercentage()) / 100D;
            case "SecondVisit":
                return (100 - ClientGroupDiscount.SecondVisit.getDiscountPercentage()) / 100D;
            case "VIP":
            default:
                return (100 - ClientGroupDiscount.VIP.getDiscountPercentage()) / 100D;
        }

    }
}
