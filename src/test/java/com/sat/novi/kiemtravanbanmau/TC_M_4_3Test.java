package com.sat.novi.kiemtravanbanmau;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_4_3Test extends BasicTest {
    
    @Test
    public void TC_4_3() {


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

        logger.info("5. Chọn 'Văn bản mẫu'");
        driver.findElement(By.xpath("//*[@href='#/quan-ly-danh-muc/van-ban-mau']")).click();
        Utils.hardWait(1000);

        logger.info("6. Click 'Thêm mới'");
        driver.findElement(By.tagName("button")).click();

        logger.info("7. Nhập 'Tên văn bản'");
        driver.findElement(By.xpath("(//*[@class='ant-input'])[1]")).sendKeys("Văn bản thống kê");
        Utils.hardWait(1000);

        logger.info("8. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(1000);

        logger.info("Xác minh màn hình hiển thị thông báo 'Trường này không được để trống!' dưới File");
        String columnFile = driver.findElement(By.className("ant-form-item-explain-error")).getText(); 
        Assert.assertTrue(columnFile.contains("Trường này không được để trống file!"));
    }
}
