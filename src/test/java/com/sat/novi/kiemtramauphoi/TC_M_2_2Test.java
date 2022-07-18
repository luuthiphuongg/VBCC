package com.sat.novi.kiemtramauphoi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_2_2Test extends BasicTest {
    
    @Test
    public void TC_2_2() {


        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("2. Nhập tên đăng nhập và pass có trong database");
        driver.findElement(By.id("login-form_username")).sendKeys("Admin"); 
        driver.findElement(By.id("login-form_password")).sendKeys("123456"); 

        logger.info("Click button 'Đăng Nhập'");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait(3000);
        
        logger.info("3. Click 'Truy cập trang quản lý'");
        driver.findElement(By.linkText("Truy cập trang quản lý")).click();

        logger.info("4. Click 'Quản lý danh mục'");
        driver.findElement(By.xpath("//*[text()='Quản lý danh mục']")).click();

        logger.info("5. Chọn 'Mẫu phôi'");
        driver.findElement(By.xpath("//*[@href='#/quan-ly-danh-muc/mau-phoi']")).click();

        logger.info("6. Click 'Thêm mới'");
        driver.findElement(By.tagName("button")).click();

        logger.info("Nhập mô tả");
        driver.findElement(By.xpath("(//*[@class='ant-input'])[2]")).sendKeys("Description test");
        logger.info("Chọn loại phôi");
        driver.findElement(By.xpath("(//*[@type='search'])")).click();
        driver.findElement(By.xpath("(//*[text()='Phôi gốc'])")).click();

        logger.info("7. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(3000);

        logger.info("Xác minh 'Trường này không được để trống!' đối với Tên");
        String alertTen = driver.findElement(By.xpath("(//*[@role='alert'])[1]")).getText(); 
        Assert.assertTrue(alertTen.contains("Trường này không được để trống!"));

    }
}
