package com.ruixman.codeGen;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class CommUtil {

	public static String freemarkerProcess(Map input, String templateStr) {
		StringTemplateLoader stringLoader = new StringTemplateLoader();
		String template = "content";
		stringLoader.putTemplate(template, templateStr);
		Configuration cfg = new Configuration();
		cfg.setTemplateLoader(stringLoader);
		try {
			Template templateCon = cfg.getTemplate(template);
			StringWriter writer = new StringWriter();
			templateCon.process(input, writer);
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String readStringFromFile(String fileName) {
		FileInputStream in;
		String str = "";
		try {
			in = new FileInputStream(fileName);
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			str = new String(buffer, "gb2312");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String readStringFromFile(String fileName,String encode) {
		FileInputStream in;
		String str = "";
		try {
			in = new FileInputStream(fileName);
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			str = new String(buffer, encode);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void writeFile(String filePath, String vo) {


	}
}
