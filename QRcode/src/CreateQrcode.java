import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class CreateQrcode {
   public static void main(String[] args) throws WriterException, IOException {
	int width = 300;
	int heigth = 300;
	String format = "jpg";
	String content = "http://localhost:8080/G:/MyEclipseProject/QRcode/image/GuHuoZai.jpg";
    HashMap hint = new HashMap();
    hint.put(EncodeHintType.CHARACTER_SET,"utf-8");//×Ö·û¼¯
    hint.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.M);//¾À´íµÈ¼¶
    hint.put(EncodeHintType.MARGIN,"2");
    BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,width,heigth); 
    MatrixToImageWriter.writeToPath(bitMatrix,format,new File("C:/Users/Administrator/Desktop/we.jpg").toPath());	
   }
}
