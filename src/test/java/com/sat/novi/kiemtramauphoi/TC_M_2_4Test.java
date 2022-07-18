package com.sat.novi.kiemtramauphoi;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_2_4Test extends BasicTest {
    
    @Test
    public void TC_2_4() {


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

        logger.info("7. Nhập tên với ít hơn 10 ký tự");
        driver.findElement(By.className("ant-input")).sendKeys("Test");
        logger.info("Nhập mô tả");
        driver.findElement(By.id("form-create-template_description")).sendKeys("Description test");
        logger.info("Chọn loại phôi");
        driver.findElement(By.xpath("(//*[@type='search'])")).click();
        driver.findElement(By.xpath("(//*[text()='Phôi gốc'])")).click();

        logger.info("8. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(3000);

        logger.info("Xác minh 'Độ dài của trường từ 10-100 ký tự' hiển thị dưới trường Tên");
        String alertLoaiphoi = driver.findElement(By.xpath("//*[@role='alert']")).getText(); 
        Assert.assertTrue(alertLoaiphoi.contains("Độ dài của trường từ 10-100 ký tự"));

    }
}
