package controller.FileData;

import java.io.*;
import java.util.ArrayList;

public class FileManagement<T> implements WriteAndRead<T> {
    private String filePatch;
    private ArrayList<T> t;

    public FileManagement(String filePatch, ArrayList<T> t) {
        this.filePatch = filePatch;
        this.t = t;
    }

    @Override
    public void Write() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePatch);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(t);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<T> Read() {
        ArrayList<T> tArrayList = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePatch);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tArrayList = (ArrayList<T>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tArrayList;
    }
}
