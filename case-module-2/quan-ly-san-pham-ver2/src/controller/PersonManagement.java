package controller;

import controller.FileData.FileManagement;
import model.Account;
import model.Person;

import java.util.ArrayList;

public class PersonManagement {

    public static final String PEOPLE_DATA = "E:\\CodeGym\\case-module-2\\quan-ly-san-pham-ver2\\peopleData.txt";

    private ArrayList<Person> people = new ArrayList<>();

    private FileManagement<Person> fileManagement = new FileManagement<>(PEOPLE_DATA, people);

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void save() {
        fileManagement.Write();
    }

    public void read() {
        people = fileManagement.Read();
    }

    public int searchIndexByAccount(Account account) {
        int index = -1;
        for (int i = 0; i < people.size(); i++) {
            if (account.equals(people.get(i))) {
                index = i;
            }
        }
        return index;
    }

    public void add(Person person) {
        people.add(person);
    }

    public boolean edit(Account account, Person person) {
        int index = searchIndexByAccount(account);
        if (index == -1) {
            return false;
        }
        people.set(index, person);
        return true;
    }

    public boolean remove(Account account) {
        int index = searchIndexByAccount(account);
        if (index == -1) {
            return false;
        }
        people.remove(index);
        return true;
    }
}
