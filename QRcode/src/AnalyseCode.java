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
        BufferedImage bi = ImageIO.read(file);//读取文件识别成图片
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(bi)));
        HashMap hint = new HashMap();
        hint.put(EncodeHintType.CHARACTER_SET,"utf-8");
        Result result = mfr.decode(bitmap,hint);
        System.out.println("解析结果"+result.toString());//解析结果www.baidu.com
        System.out.println("二维码类型"+result.getBarcodeFormat());//二维码类型QR_CODE
        System.out.println("二维码文本内容"+result.getText());//二维码文本内容www.baidu.com
	 }
}
