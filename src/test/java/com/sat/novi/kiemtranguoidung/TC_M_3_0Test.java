package com.sat.novi.kiemtranguoidung;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.sat.utils.BasicTest;
import com.sat.utils.Utils;
public class TC_M_3_0Test extends BasicTest {
    @Test
    public void ND_01() {

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
        Utils.hardWait(1000);

        logger.info("Xác minh màn hình hiển thị những cột thông tin: Tài khoản, Họ tên, SĐT, Email, Nhóm người dùng, Đơn vị, Tác vụ");
        String columnTen = driver.findElement(By.className("ant-table-cell")).getText(); 
        Assert.assertTrue(columnTen.contains("Tài khoản"));
        String columnLoaiphoi = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[2]")).getText(); 
        Assert.assertTrue(columnLoaiphoi.contains("Họ tên"));
        String columnDaxuatban = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[3]")).getText(); 
        Assert.assertTrue(columnDaxuatban.contains("SĐT"));
        String columnAnhmota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[4]")).getText(); 
        Assert.assertTrue(columnAnhmota.contains("Email"));
        String columnMota = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[5]")).getText(); 
        Assert.assertTrue(columnMota.contains("Nhóm người dùng"));
        String columnDonvi = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[6]")).getText(); 
        Assert.assertTrue(columnDonvi.contains("Đơn vị"));
        String columnTacvu = driver.findElement(By.xpath("(//*[@class='ant-table-cell'])[7]")).getText(); 
        Assert.assertTrue(columnTacvu.contains("Tác vụ"));
    }
}
