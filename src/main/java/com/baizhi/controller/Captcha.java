package com.baizhi.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/captcha")
public class Captcha {
	@RequestMapping("/createCaptcha.do")
	public void createCaptcha(HttpSession session,HttpServletResponse response) throws Exception{ 
		// 生成验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		/**
		 * 将随机数存入session 
		 */
		session.setAttribute("code", securityCode);
		// 生成验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode);
		// 将验证码响应到客户端（图片，格式，流）
		ImageIO.write(image, "png", response.getOutputStream());
	}
}







