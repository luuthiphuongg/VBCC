package com.sat.novi.kiemtravanbanmau;

import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_4_5Test extends BasicTest {
    
    @Test
    public void VBM_12() {
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
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("(//*[@class='ant-input'])[1]")).sendKeys("Văn bản thống kê");
        Utils.hardWait(1000);

        logger.info("8. Upload File");
        String Path_TestData7 = System.getProperty("user.dir") + File.separator + "src/test/resources/testdata/Novi/GiayUyQuyen.pdf";
        driver.findElement(By.xpath("(//input[@id='form-create-documentTemplate_file'])[1]")).sendKeys(Path_TestData7);
        Utils.hardWait(1000);

        logger.info("9. Click 'Lưu'");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Utils.hardWait(1000);

        logger.info("Xác minh Thêm mới thành công");
        String successSave = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[1]")).getText(); 
        Assert.assertTrue(successSave.contains("Tên văn bản"));
    }
}
