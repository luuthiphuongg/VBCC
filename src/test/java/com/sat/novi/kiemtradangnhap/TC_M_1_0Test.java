package com.sat.novi.kiemtradangnhap;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.sat.utils.BasicTest;
public class TC_M_1_0Test extends BasicTest{

    @Test
    public void DN_01() {

        logger.info("1. Mở trang chủ");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        
        logger.info("Xác minh màn hình hiển thị 'Tên đăng nhập Textbox'");
        String verifyLoginTextBox = driver.findElement(By.id("login-form_username")).getAttribute("type"); 
        Assert.assertEquals(verifyLoginTextBox, "text");

        logger.info("Xác minh màn hình hiển thị 'Mật khẩu Textbox'");
        String verifyPassTextBox = driver.findElement(By.id("login-form_password")).getAttribute("type"); 
        Assert.assertEquals(verifyPassTextBox, "password");

        logger.info("Xác minh màn hình hiển thị button Đăng nhập");
        String verifyLoginButton = driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).getText(); 
        Assert.assertTrue(verifyLoginButton.contains("Đăng Nhập"));
    }
}
