package com.sat.novi.kiemtramauphoi;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.sat.utils.BasicTest;
import com.sat.utils.Utils;

public class TC_M_2_0Test extends BasicTest {
    @Test
    public void TC_2_0() {
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
        Utils.hardWait(12000);

        logger.info("Xác minh màn hình hiển thị những cột thông tin: Tên, Loại phôi, Đã xuất bản, Ảnh mô tả, Mô tả, Tác vụ");
        String columnTen = driver.findElement(By.className("ant-table-cell")).getText(); 
        Assert.assertTrue(columnTen.contains("Tên"));
        String columnLoaiphoi = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[2]")).getText(); 
        Assert.assertTrue(columnLoaiphoi.contains("Loại phôi"));
        String columnDaxuatban = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[3]")).getText(); 
        Assert.assertTrue(columnDaxuatban.contains("Đã xuất bản"));
        String columnAnhmota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[4]")).getText(); 
        Assert.assertTrue(columnAnhmota.contains("Ảnh mô tả"));
        String columnMota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[5]")).getText(); 
        Assert.assertTrue(columnMota.contains("Mô tả"));
        String columnTacvu = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[6]")).getText(); 
        Assert.assertTrue(columnTacvu.contains("Tác vụ"));

    }
}
