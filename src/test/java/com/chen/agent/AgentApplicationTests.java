package com.chen.agent;

import com.chen.agent.agent.TravelPlanAgent;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AgentApplicationTests {

    @Resource
    private TravelPlanAgent  travelPlanAgent;

    @Test
    void test() {
        travelPlanAgent.run("帮我把“你好”,这句话写到txt文件中");
    }

}
