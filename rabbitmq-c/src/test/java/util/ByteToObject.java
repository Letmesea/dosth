package util;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * @author Letmesea
 * @title: ByteToObject
 * @projectName dosth
 * @description: byte 2 object
 * @date 2020/6/1710:44
 */
public class ByteToObject {
    public static Object byteToObject(byte[] bytes) {
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);


            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }
}
