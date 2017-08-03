package org.linda.restdemo.component;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileIO {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void saveFile(byte[] file, String path) throws IOException {
		BufferedOutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(path));
			System.out.println("writing file " + path);
			out.write(file);
		} catch (IOException e1) {
			logger.error("when path = " + path, e1);
		} finally {
			if (out != null)
				out.close();
		}
	}

	public byte[] getFile(String fileName) throws IOException {
		byte[] file = null;
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(fileName));
			System.out.println("geting file " + fileName);
			file = new byte[in.available()];
			in.read(file);
		} catch (FileNotFoundException e) {
			logger.error("when fileName = " + fileName, e);
		} catch (IOException e1) {
			logger.error("when fileName = " + fileName, e1);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return file;
	}

	public boolean downloadFile(String url, String fileName) {
		boolean res = true;
		try {
			File file = new File(fileName);
			FileUtils.copyURLToFile(new URL(url), file);
		} catch (Exception e) {
			logger.error("when fileName = " + fileName, e);
			res = false;
		}
		return res;
	}

}
