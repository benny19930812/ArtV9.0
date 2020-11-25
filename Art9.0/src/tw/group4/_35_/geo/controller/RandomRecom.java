package tw.group4._35_.geo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;

import tw.group4._35_.geo.model.InterfacePositionService;
import tw.group4._35_.geo.model.Position;
import tw.group4._35_.util.QRCodeGenerator;
import tw.group4.util.IdentityFilter;

@Controller
public class RandomRecom{
	
	@Autowired
	private InterfacePositionService ptService;
	
	@Autowired
	private ServletContext ctx;
	
	@RequestMapping(path = "/35/randomRecom.ctrl", method = RequestMethod.GET)
    public String randomRecom(Model m) {

		List<Position> list = ptService.recommendList();
		m.addAttribute("recommend", list);
		
		return IdentityFilter.loginID+"35/geo/recomAct";
	}
	
	@GetMapping(path = "/35/navigate/{destionation}")
	public @ResponseBody String navigate(@PathVariable String destionation) {
		String encodedDestination = null;
	    try {
	      // 進行 URL 百分比編碼網址中的中文參數
	      encodedDestination = URLEncoder.encode(destionation, "UTF-8");
	      // 輸出結果

	    } catch (UnsupportedEncodingException e) {
	      // 例外處理 ...
	    }
	    String url = "https://www.google.com.tw/maps/dir//"+encodedDestination;
	    System.out.println("給QRCode用的網址產生完成");
		byte[] qrCodeBytes = null;
		try {
			BufferedImage qrCode = new QRCodeGenerator().getQrCode(url, ctx);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(qrCode, "png", baos);
			qrCodeBytes = baos.toByteArray();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String encodedString = Base64.encodeBase64String(qrCodeBytes);
			
		return encodedString;
		
	}
	
	@GetMapping(path = "/35/navigate/QRcode/{destionation}")
	public @ResponseBody ResponseEntity<byte[]> navigateQRcode(@PathVariable String destionation) {
		String encodedDestination = null;
		try {
			// 進行 URL 百分比編碼網址中的中文參數
			encodedDestination = URLEncoder.encode(destionation, "UTF-8");
			// 輸出結果
			
		} catch (UnsupportedEncodingException e) {
			// 例外處理 ...
		}
		String url = "https://www.google.com.tw/maps/dir//"+encodedDestination;
		System.out.println("給QRCode用的網址產生完成");
		byte[] qrCodeBytes = null;
		try {
			BufferedImage qrCode = new QRCodeGenerator().getQrCode(url, ctx);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(qrCode, "png", baos);
			qrCodeBytes = baos.toByteArray();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		
		return new ResponseEntity<byte[]>(qrCodeBytes, headers, HttpStatus.OK);
		
	}

}
