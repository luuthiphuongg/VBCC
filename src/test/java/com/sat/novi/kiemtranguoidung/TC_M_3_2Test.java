package com.sat.novi.kiemtranguoidung;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_3_2Test extends BasicTest {
    
    @Test
    public void TC_3_2() {


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

        logger.info("7. Nhập 'Tài khoản' với ít hơn 3 kí tự");
        driver.findElement(By.id("form-create-account_username")).sendKeys("SAT");

        logger.info("Nhập 'Họ tên'");
        driver.findElement(By.id("form-create-account_name")).sendKeys("SAT");

        logger.info("Nhập 'Email'");
        driver.findElement(By.id("form-create-account_email")).sendKeys("sat@gmail.com");

        logger.info("Chọn 'Đơn vị'");
        driver.findElement(By.className("ant-select-selection-search")).click();
        driver.findElement(By.xpath("//*[@title='Sở Giáo dục và Đào tạo']")).click();
        Utils.hardWait(1000);

        logger.info("Chọn 'Nhóm người dùng'");
        driver.findElement(By.xpath("(//*[@class='ant-select-selection-item'])[2]")).click();
        driver.findElement(By.xpath("//*[@title='ADMIN-ADMIN']")).click();

        logger.info("8. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(1000);
    
        logger.info("Xác minh thông báo 'Độ dài từ 6-50 ký tự' hiển thị dưới Họ tên");
        String alertTaikhoan= driver.findElement(By.xpath("//*[@role='alert']")).getText(); 
        Assert.assertTrue(alertTaikhoan.contains("Độ dài từ 6-50 ký tự"));

    }
}
