package com.chen.agent.tools;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolRegistration {

    @Bean
    public ToolCallback[] allTools() {
        return ToolCallbacks.from(
                new FileOperationTool(),
                new WebScrapingTool(),
                new TerminateTool(),
                new PDFGenerationTool()
//                new WebSearchTool(searchApiKey),
                //...
        );
    }

}
