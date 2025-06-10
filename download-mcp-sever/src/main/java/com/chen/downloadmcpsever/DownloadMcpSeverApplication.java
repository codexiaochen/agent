package com.chen.downloadmcpsever;

import com.chen.downloadmcpsever.tool.ReasourceDownloadTool;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DownloadMcpSeverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DownloadMcpSeverApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider imageSearchTools (ReasourceDownloadTool reasourceDownloadTool){
        return MethodToolCallbackProvider.builder()
                .toolObjects(reasourceDownloadTool)
                .build();
    }


}
