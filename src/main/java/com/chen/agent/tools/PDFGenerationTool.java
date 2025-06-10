package com.chen.agent.tools;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.IOException;


public class PDFGenerationTool {

    private final String FILE_DIR = "D:/demo/agent/data";

    @Tool(description = "Generate a PDF file from given content")
    public String generatePDF(@ToolParam(description = "Name of the file to save the generated PDF") String fileName,
                              @ToolParam(description = "Content to be included inthe PDF") String content) {
        String fileDir = FILE_DIR;
        String filePath = fileDir + "/" + fileName;
        try {
            FileUtil.mkdir(fileDir);
            PdfWriter pdfWriter = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);
            //设置字体
            PdfFont font = PdfFontFactory.createFont("STSongStd-Light");
            document.setFont(font);
            // 添加段落
            Paragraph paragraph = new Paragraph(content);
            document.add(paragraph);
            return "PDF generated successfully at " + filePath;
        } catch (IOException e) {
            return "Error generating PDF: " + e.getMessage();
        }
    }
}
