package com.sat.novi.kiemtranguoidung;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_3_6Test extends BasicTest {
    
    @Test
    public void TC_3_6() {


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

        logger.info("4. Click 'Quản lý nhóm và tài khoản'");
        driver.findElement(By.xpath("//*[text()='Quản lý nhóm và tài khoản']")).click();

        logger.info("5. Click 'Người dùng'");
        driver.findElement(By.xpath("//*[@href='#/quan-ly-nhom-va-tai-khoan/nguoi-dung']")).click();

        logger.info("6. Click 'Thêm mới'");
        driver.findElement(By.tagName("button")).click();

        logger.info("7. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(3000);
    
        logger.info("Xác minh thông báo 'Trường này không được để trống!' hiển thị dưới Tài khoản, Họ tên, Email, Đơn vị, Nhóm người dùng");
        String alertTaikhoan= driver.findElement(By.xpath("//*[@role='alert']")).getText(); 
        Assert.assertTrue(alertTaikhoan.contains("Trường này không được để trống!"));
        String alertHoten= driver.findElement(By.xpath("(//*[@role='alert'])[2]")).getText(); 
        Assert.assertTrue(alertHoten.contains("Trường này không được để trống!"));
        String alertEmail= driver.findElement(By.xpath("(//*[@role='alert'])[3]")).getText(); 
        Assert.assertTrue(alertEmail.contains("Email không đúng định dạng!"));
        String alertDonvi= driver.findElement(By.xpath("(//*[@role='alert'])[4]")).getText(); 
        Assert.assertTrue(alertDonvi.contains("Trường này không được để trống!"));
        String alertNhomnguoidung= driver.findElement(By.xpath("(//*[@role='alert'])[5]")).getText(); 
        Assert.assertTrue(alertNhomnguoidung.contains("Trường này không được để trống!"));

    }
}
