package controller;

import controller.FileData.FileManagement;
import model.Bill;

import java.util.ArrayList;

public class BillManagement{
    public static final String BILL_DATA = "E:\\CodeGym\\case-module-2\\quan-ly-san-pham-ver2\\billData.txt";

    private ArrayList<Bill> bills = new ArrayList<>();

    private FileManagement<Bill> billFileManagement = new FileManagement<>(BILL_DATA, bills);

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public int searchIndexById(String id) {
        int index = -1;
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void add(Bill bill) {
        bills.add(bill);
    }

    public boolean remove(String id) {
        int index = searchIndexById(id);
        if (index == -1) {
            return false;
        }
        bills.remove(index);
        return true;
    }

    public boolean edit(String id, Bill bill) {
        int index = searchIndexById(id);
        if (index == -1) {
            return false;
        }
        bills.set(index, bill);
        return true;
    }

    public void save() {
        billFileManagement.Write();
    }

    public void read() {
        bills = billFileManagement.Read();
    }

}
