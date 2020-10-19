// 
// Decompiled by Procyon v0.5.36
// 

package util;

import java.io.File;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtility
{
    public static void writeBytes(final String fileName, final byte[] data) throws Exception {
        final FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();
        System.out.println("Done");
    }
    
    public static Object readFileDeserialize(final String name) {
        Object obj = null;
        try {
            final ObjectInputStream in = new ObjectInputStream(new FileInputStream(name));
            try {
                obj = in.readObject();
                in.close();
            }
            catch (Throwable t) {
                try {
                    in.close();
                }
                catch (Throwable exception) {
                    t.addSuppressed(exception);
                }
                throw t;
            }
        }
        finally {
            return obj;
        }
    }
    
    public static boolean writeObjectToFile(final Object object, final String name) throws RuntimeException {
        try {
            final FileOutputStream fout = new FileOutputStream(name);
            try {
                final ObjectOutputStream oos = new ObjectOutputStream(fout);
                try {
                    oos.writeObject(object);
                    final boolean b = true;
                    oos.close();
                    fout.close();
                    return b;
                }
                catch (Throwable t) {
                    try {
                        oos.close();
                    }
                    catch (Throwable exception) {
                        t.addSuppressed(exception);
                    }
                    throw t;
                }
            }
            catch (Throwable t2) {
                try {
                    fout.close();
                }
                catch (Throwable exception2) {
                    t2.addSuppressed(exception2);
                }
                throw t2;
            }
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static byte[] readBytes(final String fileName) throws Exception {
        final File file = new File(fileName);
        final FileInputStream fileInputStream = new FileInputStream(file);
        try {
            final byte[] bytesArray = new byte[(int)file.length()];
            fileInputStream.read(bytesArray);
            final byte[] array = bytesArray;
            fileInputStream.close();
            return array;
        }
        catch (Throwable t) {
            try {
                fileInputStream.close();
            }
            catch (Throwable exception) {
                t.addSuppressed(exception);
            }
            throw t;
        }
    }
}
