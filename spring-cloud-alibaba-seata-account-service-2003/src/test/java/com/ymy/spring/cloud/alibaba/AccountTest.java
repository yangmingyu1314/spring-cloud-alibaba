package com.ymy.spring.cloud.alibaba;

import com.ymy.spring.cloud.alibaba.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private AccountMapper accountMapper;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testConnection() throws Exception{
        logger.info("测试连接：" + dataSource.getConnection());
    }

    @Test
    public void testAccountMapperDecrease() {
        int ret = accountMapper.decrease(1, new BigDecimal(30));
        logger.info("测试结果：" + ret);
    }
}
