package ua.com.serialization;

import java.io.*;

public class SerializationUtils<T> {

    public void encodeAndSaveToFile(String filePath, T object) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(object);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Object loadFromFileAndDecode(String filePath) {
        Object object;
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                object = objectInputStream.readObject();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return object;
    }
}
