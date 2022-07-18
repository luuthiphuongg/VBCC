package com.sat.novi.kiemtradangnhap;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;

public class TC_M_1_8Test extends BasicTest {
    
    @Test
    public void DN_09() {

        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Nhập tên đăng nhập có trong database");
        driver.findElement(By.id("login-form_username")).sendKeys(" Admin "); 

        logger.info("3. Nhập mật khẩu có trong database");
        driver.findElement(By.id("login-form_password")).sendKeys("123456"); 

        logger.info("Xác minh textbox mật khẩu xuất hiện dưới dạng mã hoá");
        String verifyLoginTextBox = driver.findElement(By.id("login-form_password")).getAttribute("type"); 
        Assert.assertEquals(verifyLoginTextBox, "password");
    }
}
