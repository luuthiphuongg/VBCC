package com.sat.novi.kiemtradangnhap;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_1_3Test extends BasicTest {
    
    @Test
    public void DN_04() {


        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Nhập tên đăng nhập có trong database");
        driver.findElement(By.id("login-form_username")).sendKeys("Admin"); 

        logger.info("3. Nhập mật khẩu sai");
        driver.findElement(By.id("login-form_password")).sendKeys("@SAT"); 

        logger.info("4. Click button 'Đăng Nhập'");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait();

        logger.info("Xác minh thông báo Tài khoản hoặc mật khẩu không đúng");
        String verifyAlert = driver.findElement(By.className("ant-alert-message")).getText(); 
        Assert.assertTrue(verifyAlert.contains("Tài khoản hoặc mật khẩu không đúng"));

    }
}
