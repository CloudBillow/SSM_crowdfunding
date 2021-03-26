import com.miracle.entity.Admin;
import com.miracle.mapper.AdminMapper;
import com.miracle.service.api.AdminService;
import com.miracle.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Miracle
 * @version v1.0
 * @description testConnection
 * @date 2021-03-26 16:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml",
        "classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private DataSource datasource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testAdminService() {
        Admin admin = new Admin(
                null, "aaa", "123456",
                "哈哈", "123456@qq.com", null
        );
        adminService.saveAdmin(admin);
    }

    @Test
    public void testInsert() {
        Admin admin = new Admin(
                null, "Miracle", "123456",
                "哈哈", "123456@qq.com", null
        );
        adminMapper.insert(admin);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testQuery() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(admin);
    }

    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        logger.debug("Hello I am debug level!");
        logger.error("Hello I am error level!");
        logger.warn("Hello I am warn level!");
        logger.info("Hello I am info level!");
    }

}
