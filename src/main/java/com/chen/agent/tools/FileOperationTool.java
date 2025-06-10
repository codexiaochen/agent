package com.chen.agent.tools;

import cn.hutool.core.io.FileUtil;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

public class FileOperationTool {

    private final String FILE_DIR = "D:/demo/agent/data";

    @Tool(description = "Read content from a file")
    public String readFile(@ToolParam(description = "Name of the file to read") String fileName) {
        String filePath = FILE_DIR + fileName;
        try{
            return FileUtil.readUtf8String(filePath);  //将读取到的文件内容以字符串形式返回
        }catch (Exception e){
            return "Error reading file: " + e.getMessage();
        }
    }

    @Tool(description = "Write content to a file")
    public String writeFile(@ToolParam(description = "Name of the file to write") String fileName,
                            @ToolParam(description = "Content to write to the file") String content) {
        String filePath = FILE_DIR + '/' + fileName;
        try{
            FileUtil.mkdir(FILE_DIR);
            FileUtil.writeString(content, filePath, "UTF-8");
            return "File written successfully";
        }catch (Exception e){
            return "Error writing file: " + e.getMessage();
        }

    }

}
