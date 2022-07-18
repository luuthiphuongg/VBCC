package com.sat.novi.kiemtradangnhap;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_1_5Test extends BasicTest {
    
    @Test
    public void DN_06() {

        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Để trống tên đăng nhập");

        logger.info("3. Nhập mật khẩu có trong database");
        driver.findElement(By.id("login-form_password")).sendKeys("123456"); 

        logger.info("4. Click button 'Đăng Nhập'");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait();

        logger.info("Xác minh thông báo vui lòng nhập tên đăng nhập");
        String verifyAlert3 = driver.findElement(By.className("ant-form-item-explain-error")).getText(); 
        Assert.assertTrue(verifyAlert3.contains("Vui lòng nhập tên đăng nhập"));
    }
}
