package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jdd on 2020/1/4.
 */
@Service
public class TestService {
    @Autowired
    TestClientFeign testClientFeign;

    public String echo(String str)
    {
        return testClientFeign.echo(str);
    }
}
