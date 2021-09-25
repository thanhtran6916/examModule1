package model;

public class Seller extends Person {
    private String license;       // số giấy phép
    private String phone;
    private String address;

    public Seller(Account account, String role, String license, String phone, String address) {
        super(account, role);
        this.license = license;
        this.phone = phone;
        this.address = address;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
