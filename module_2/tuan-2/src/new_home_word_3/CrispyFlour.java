package new_home_word_3;

import java.time.LocalDate;

public class CrispyFlour extends Material{
    private double quantity;

    protected CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, double quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    protected LocalDate getExpiryDate() {
        return null;
    }

    @Override
    protected double getAmount() {
        return 0;
    }
}
