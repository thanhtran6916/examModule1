package new_home_word_3;

import java.time.LocalDate;

public abstract class Material {
    private String id;
    private String name;
    private LocalDate manufacturingDate;
    private int cost;

    protected Material() {

    }

    protected Material(String id, String name, LocalDate manufacturingDate, int cost) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.cost = cost;
    }

    protected String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    protected void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    protected int getCost() {
        return cost;
    }

    protected void setCost(int cost) {
        this.cost = cost;
    }

    protected abstract LocalDate getExpiryDate();

    protected abstract double getAmount();
}
