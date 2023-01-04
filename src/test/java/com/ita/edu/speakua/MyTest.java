package com.ita.edu.speakua;

import com.ita.edu.speakua.jdbc.entity.UsersEntity;
import com.ita.edu.speakua.jdbc.services.UsersService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {


    @Test
    public void DBUser() {
        UsersService service = new UsersService();
        UsersEntity user = service.getByEmail("galamagal86@gmail.com");
        Assert.assertEquals(user.getId(), 292);
        user = service.getByEmail("galamagal86+1@gmail.com");
        Assert.assertNull(user);

    }
}