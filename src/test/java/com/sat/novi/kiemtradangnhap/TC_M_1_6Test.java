package com.sat.novi.kiemtradangnhap;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_1_6Test extends BasicTest {
    
    @Test
    public void DN_07() {

        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Nhập tên đăng nhập có trong database");
        driver.findElement(By.id("login-form_username")).sendKeys("Admin");

        logger.info("3. Để trống mật khẩu");
        driver.findElement(By.id("login-form_password")).sendKeys("");

        logger.info("4. Click button 'Đăng Nhập'");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait();

        logger.info("Xác minh thông báo vui lòng nhập mật khẩu");
        String verifyAlert4 = driver.findElement(By.className("ant-form-item-explain-error")).getText(); 
        Assert.assertTrue(verifyAlert4.contains("Vui lòng nhập mật khẩu."));
    }
}
