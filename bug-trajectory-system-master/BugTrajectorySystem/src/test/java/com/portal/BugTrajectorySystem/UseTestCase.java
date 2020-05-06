package com.portal.BugTrajectorySystem;


import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.portal.config.DBConfig;
import com.portal.models.User;
import com.portal.service.UserService;



public class UseTestCase {
                
    private static UserService userServiceObj;
    
    @BeforeClass
    public static void init() {
                    System.out.println("BEfore Init");
                    try {
                    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
                    userServiceObj=context.getBean("UserService",UserService.class);
                    }
                    catch(Exception e) {
                                    e.printStackTrace();
                    }
                    System.out.println("After Init");
    }
    
    @Test 
    public void validateTest() {
                    User obj=userServiceObj.validateUser("a@gmail.com", "r@123");
                    System.out.println(obj);
                    assertNotNull("User not found", obj);
    }
}
