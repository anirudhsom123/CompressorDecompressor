package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
   public static void method(File file) throws IOException {
       String fileDirectory=file.getParent();

       FileInputStream fis=new FileInputStream(file);
       FileOutputStream fos=new FileOutputStream(fileDirectory+"/compressedFile.gz");
       GZIPOutputStream GZIP=new GZIPOutputStream(fos);

       Byte[] Buffer=new Byte[1024];
       int len;





    }
    public static void main(String[] args) throws IOException {
       File path=new File("/Users/anirudhsom/Desktop/Testfile");
       method(path);
    }
}
