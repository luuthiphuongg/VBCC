package com.sat.novi.kiemtravanbanmau;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
public class TC_M_4_0Test extends BasicTest {
    @Test
    public void VBM_01() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://dev.vbcc.com.vn/?fbclid=IwAR2zSKNYphds68hNVeeEePVRzWHLNb-Vq6MnfD-4RTrl8U-IyOS1avvhL9M#/auth/login");
        driver.findElement(By.id("login-form_username")).sendKeys("Admin"); 
        driver.findElement(By.id("login-form_password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@class='ant-btn ant-btn-primary ant-btn-lg']")).click();
        Utils.hardWait(3000);
        driver.findElement(By.linkText("Truy cập trang quản lý")).click();

        logger.info("4. Click 'Quản lý danh mục'");
        driver.findElement(By.xpath("//*[text()='Quản lý danh mục']")).click();

        logger.info("5. Chọn 'Văn bản mẫu'");
        driver.findElement(By.xpath("//*[@href='#/quan-ly-danh-muc/van-ban-mau']")).click();
        Utils.hardWait(2000);

        logger.info("Xác minh màn hình hiển thị những cột thông tin: Tên văn bản, Mô tả, Ảnh mô tả, Tạo bởi, Ngày tạo, Tác vụ");
        String columnTen = driver.findElement(By.className("ant-table-cell")).getText(); 
        Assert.assertTrue(columnTen.contains("Tên văn bản"));
        String columnLoaiphoi = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[2]")).getText(); 
        Assert.assertTrue(columnLoaiphoi.contains("Mô tả"));
        String columnDaxuatban = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[3]")).getText(); 
        Assert.assertTrue(columnDaxuatban.contains("Ảnh mô tả"));
        String columnAnhmota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[4]")).getText(); 
        Assert.assertTrue(columnAnhmota.contains("Tạo bởi"));
        String columnMota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[5]")).getText(); 
        Assert.assertTrue(columnMota.contains("Ngày tạo"));
        String columnTacvu = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[6]")).getText(); 
        Assert.assertTrue(columnTacvu.contains("Tác vụ"));
    }
}
