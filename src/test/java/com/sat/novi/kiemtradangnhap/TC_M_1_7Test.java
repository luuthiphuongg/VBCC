package com.sat.novi.kiemtradangnhap;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_1_7Test extends BasicTest {
    
    @Test
    public void DN_08() {

        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Nhập tên đăng nhập có khoảng trắng đầu cuối");
        driver.findElement(By.id("login-form_username")).sendKeys(" Admin "); 

        logger.info("3. Nhập mật khẩu có trong database");
        driver.findElement(By.id("login-form_password")).sendKeys("123456"); 

        logger.info("4. Click button 'Đăng Nhập'");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait();

        logger.info("Xác minh đăng nhập thành công");
        String verifyLoginSuccess = driver.findElement(By.xpath("//i [@style]")).getText(); 
        Assert.assertFalse(verifyLoginSuccess.contains("Chào "+"Admina"+"!"));
        //TCs failed
    }
}
