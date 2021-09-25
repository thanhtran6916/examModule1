package controller.FileData;

import java.util.ArrayList;

public interface WriteAndRead<T> {

    void Write();

    ArrayList<T> Read();
}
