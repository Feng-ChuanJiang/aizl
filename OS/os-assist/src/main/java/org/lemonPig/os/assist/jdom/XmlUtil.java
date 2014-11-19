package org.lemonPig.os.assist.jdom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XmlUtil {
	public static Document getDom(File file) {
		Document document = null;
		try {
			document = getDom(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return document;
	}
	public static Document getDom(InputStream inputStream) {
		SAXBuilder saxBuilder = new SAXBuilder();
		Document doc = null;
		try {
			doc = saxBuilder.build(inputStream);
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	public static void saveDom(Document document,File file) {
		Format format = Format.getCompactFormat();
		// 设置XML文件的缩进为4个空格
		format.setIndent("    ");
		// 设置XML文件的字符集为UTF-8
		format.setEncoding("UTF-8");
		// 将格式应用到输出流中
		XMLOutputter XMLOut = new XMLOutputter(format);
		// 将文档通过文件输出流生成xml文件
		try {
			XMLOut.output(document, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
