package com.sat.novi.kiemtravanbanmau;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_4_7Test extends BasicTest {
    
    @Test
    public void VBM_16() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        driver.findElement(By.id("login-form_username")).sendKeys("Admin"); 
        driver.findElement(By.id("login-form_password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait(3000);
        driver.findElement(By.linkText("Truy cập trang quản lý")).click();
        driver.findElement(By.xpath("//*[text()='Quản lý danh mục']")).click();
        driver.findElement(By.xpath("//*[@href='#/quan-ly-danh-muc/van-ban-mau']")).click();
        Utils.hardWait(1000);

        logger.info("6. Click 'Sửa'");
        driver.findElement(By.xpath("//*[@data-icon='edit']")).click();

        logger.info("7. Sửa 'Mô tả'");
        Utils.hardWait(1000);
        driver.findElement(By.xpath("(//*[@type='text'])[2]")).sendKeys(" mô tả hồ sơ tốt nghiệp");
        Utils.hardWait(1000);

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(1000);
        String successSave = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[8]")).getText(); 
        Assert.assertTrue(successSave.contains("mô tả hồ sơ tốt nghiệp"));
    }
}
