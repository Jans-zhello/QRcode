import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class AnalyseCode {

	public static void main(String[] args) throws IOException, NotFoundException {
		MultiFormatReader mfr = new MultiFormatReader();
        File file = new File("C:\\Users\\Administrator\\Desktop\\we.jpg");
        BufferedImage bi = ImageIO.read(file);//��ȡ�ļ�ʶ���ͼƬ
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bi)));
        HashMap hint = new HashMap();
        hint.put(EncodeHintType.CHARACTER_SET,"utf-8");
        Result result = mfr.decode(bitmap,hint);
        System.out.println("�������"+result.toString());//�������www.baidu.com
        System.out.println("��ά������"+result.getBarcodeFormat());//��ά������QR_CODE
        System.out.println("��ά���ı�����"+result.getText());//��ά���ı�����www.baidu.com
	 }
}
