package com.chen.agent.agent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode(callSuper = true)
//@Data
@Slf4j
public abstract class ReActAgent extends BaseAgent {

    /**
     * 思考当前状态并决定下一步行动
     * @return
     */
    public abstract boolean think();

    /**
     * 执行think的行动
     * @return
     */
    public abstract String act();

    @Override
    public String step() {
        try {
            //先思考
            Boolean shouldAct = think();
            if (!shouldAct) {
                return "思考完成 - 无需行动";
            }
            //再行动
            return act();
        } catch (Exception e) {
            log.info("步骤执行失败：" + e.getMessage());
            // 记录异常日志
//            e.printStackTrace();
            return "步骤执行失败：" + e.getMessage();
        }
    }
}
