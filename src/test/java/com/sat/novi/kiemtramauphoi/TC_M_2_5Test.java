package com.sat.novi.kiemtramauphoi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_2_5Test extends BasicTest {
    
    @Test
    public void TC_2_5() {


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

        logger.info("7. Nhập các thông tin đúng và đủ");
        logger.info("Nhập Tên");
        driver.findElement(By.className("ant-input")).sendKeys("Testing title");
        logger.info("Nhập mô tả");
        driver.findElement(By.id("form-create-template_description")).sendKeys("Description test");
        logger.info("Chọn loại phôi");
        driver.findElement(By.xpath("(//*[@type='search'])")).click();
        driver.findElement(By.xpath("(//*[text()='Phôi gốc'])")).click();
        logger.info("Chọn 'Xuất bản'");
        driver.findElement(By.className("ant-switch-handle")).click();

        logger.info("8. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(3000);
        driver.findElement(By.xpath("(//*[@class='ant-btn ant-btn-primary'])[2]")).click();
        Utils.hardWait(500);

        logger.info("Xác minh Lưu dữ liệu thành công");
        String success = driver.findElement(By.xpath("(//*[@class='ant-notification-notice-message'])")).getText(); 
        Assert.assertTrue(success.contains("Lưu dữ liệu thành công"));

    }
}
