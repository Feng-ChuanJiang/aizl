package org.lemonPig.os.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;





public class FileUtils {
	public static String getEtag(File file) {
		Integer path=file.getAbsolutePath().hashCode();
		Long fileSize=file.length();
		Long lastModify=file.lastModified(); 
		String etag=Integer.toHexString(path)+Long.toHexString(fileSize)+Long.toHexString(lastModify);
		return etag;
	}
	/**
	 * 获取系统所剩空间最大盘符
	 * @return
	 */
	public static File getMaxRoot() {
		File maxUsableSpaceFile=null;
		long maxUsableSpace=0L;
		File[] files=listFileRoot();
		for (File file : files) {
			long usableSpace=file.getUsableSpace();
			if (usableSpace>maxUsableSpace) {
				maxUsableSpace=usableSpace;
				maxUsableSpaceFile=file;
			}
		}
		return maxUsableSpaceFile;
	}
	/**
	 * 获取系统所有盘符
	 * @return
	 */
	public static File[] listFileRoot() {
		return File.listRoots();
	}
	
	/**
	 * 获取当前项目所在系统盘
	 * @return
	 */
	public static String getSystemRoot() {
		String classPath=getClassPath();
		return classPath.substring(0,classPath.indexOf(File.separator));
	}
	/**
	 * 获取当前项目classpath的盘符路径
	 * @return
	 */
	public static String getClassPath() {
		return FileUtils.class.getResource("/").getPath();
	}
	/**
	 * 获取当前项目webRoot的盘符路径
	 * @return
	 */
	public static String getWebRoot() {
		return System.getProperty("webapp.root");
	}

	/**
	 * 将流保存为文件，路径格式实例如下： 类加载路径classpath:conf/file1.txt
	 * 盘符路径file:D:/conf/file1.txt
	 * 
	 * @param in
	 *            输入流
	 * @param pathname
	 *            保存路径
	 */
	public static void saveFile(InputStream in, String pathname) {
		File file = getResourcAsFile(pathname);
		saveFile(in, file);
	}
	public static void dropFile(List<String> filePaths) {
		for (String filePath : filePaths) {
			dropFile(filePath);
		}
	}
	public static void dropFile(String filePath) {
		File file=new File(filePath);
		dropFile(file);
	}
	public static void dropFile(File file) {
		if (file.exists()) {
			file.delete();
		}
	}
	public static void dropFiles(List<File> files) {
		for (File file : files) {
			dropFile(file);
		}
	}

	/**
	 * 将流保存为文件
	 * 
	 * @param in
	 * @param file
	 * @throws
	 */
	public static void saveFile(InputStream in, File file)  {
		if (file.exists()) {
			file.delete();
		}
		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		byte[] temp = new byte[1024 * 5];
		int length = 0;
		try {
			while ((length = in.read(temp)) > 0) {
				out.write(temp, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 将文件读取为inputstream 该流使用完后需关闭
	 * @param file
	 * @return
	 */
	public static InputStream getResourcAsStream(File file) {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将文件读取为inputstream 该流使用完后需关闭
	 * @param file
	 * @return
	 */
	public static InputStream getResourcAsStream(String resourceLocation)  {
		File file=getResourcAsFile(resourceLocation);
		return getResourcAsStream(file);
	}
	/**
	 * 将inputstream以指定编码，按字节流读取并转换为字符串返回
	 * @param in 输入流
	 * @param encoding 读取编码
	 * @return 流按指定编码读取并转换后的字符串
	 */
	public static String fileToString(InputStream in, String encoding) {
		StringBuffer content = new StringBuffer();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,
				encoding))){
			String temp = null;
			int i = 0;
			while ((temp = bufferedReader.readLine()) != null) {
				if (i++ != 0)content.append(System.getProperty("line.separator"));
				temp = new String(temp.getBytes(), System.getProperty("file.encoding"));
				content.append(temp);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}
	/**
	 * 将inputstream以指定编码，按字节流读取并转换为字符串返回
	 * @param in 输入流
	 * @return 流按指定编码读取并转换后的字符串
	 */
	public static String fileToString(InputStream in) {
		StringBuffer content = new StringBuffer();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in))){
			String temp = null;
			int i = 0;
			while ((temp = bufferedReader.readLine()) != null) {
				if (i++ != 0)content.append(System.getProperty("line.separator"));
				temp = new String(temp.getBytes(), System.getProperty("file.encoding"));
				content.append(temp);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	/**
	 * 将文件用指定编码读取并转换为字符串
	 * @param file 目标文件
	 * @param encoding 读取编码
	 * @return 按指定编码读取并转换后的字符串
	 */
	public static String fileToString(File file, String encoding) {
		try(InputStream in = new FileInputStream(file)) {
			return fileToString(in, encoding);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	/**
	 * 将文件用指定编码读取并转换为字符串
	 * @param file 目标文件
	 * @return 按指定编码读取并转换后的字符串
	 */
	public static String fileToString(File file) {
		try(InputStream in = new FileInputStream(file)) {
			return fileToString(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public static File getResourcAsFile(String resourceLocation)  {
		URL url = null;
		if (resourceLocation.startsWith("classpath:")) {
			String classPath = resourceLocation
					.substring("classpath:".length());
			url = ClassUtils.getDefaultClassLoader().getResource(classPath);
		}else if (resourceLocation.startsWith("webroot:")) {
			String projectPath=resourceLocation.substring("webRoot:".length());
			String webRoot=getWebRoot();
			Assert.assertNotNull(webRoot, "webRoot获取失败，系统变量webapp.root未被初始化");
			resourceLocation="file:"+getWebRoot()+File.separator+projectPath;
			try {
				url = new URL(resourceLocation);
			} catch (MalformedURLException ex2) {
				ex2.printStackTrace();
			}
		}else {
			try {
				url = new URL(resourceLocation);
			} catch (MalformedURLException ex2) {
				ex2.printStackTrace();
			}
		}
		Assert.assertNotNull(url, "文件 :" + resourceLocation + "不存在");
		return getResourcAsFile(url);
	}
	/**
	 * 获取目标路径下的所有文件，如果采用过滤器，将筛选出符合条件的文件
	 * @param resourceLocation 目标目录
	 * @param filenameFilter 文件名过滤器
	 * @return 返回符合条件的文件
	 */
	public static File[] getResourcAsFiles(String resourceLocation,FilenameFilter filenameFilter) {
		File target=getResourcAsFile(resourceLocation);
		File[] files=null;
		if (!target.isDirectory()) {
			return new File[]{target};
		}
		if (filenameFilter!=null) {
			files=target.listFiles(filenameFilter);
		}else {
			files=target.listFiles();
		}
		return files;
	}
	/**
	 * 获取目标路径下的所有文件，如果采用过滤器，将筛选出符合条件的文件
	 * @param resourceLocation 目标目录
	 * @param ext 文件名后缀
	 * @return 返回符合条件的文件
	 */
	public static List<File> getResourcAsFiles(File file, final String ext) {
		final List<File> files=new ArrayList<File>();
		if (!file.isDirectory()) {
			if (file.getName().endsWith(ext)) {
				files.add(file);
			}
		}else {
			File[] children=file.listFiles(new FileFilter() {
				@Override
				public boolean accept(File f) {
					if (f.isDirectory()) {
						return true;
					}else {
						if (f.getName().endsWith(ext)) {
							files.add(f);
						}
						return false;
					}
				}
			});
			for (File child : children) {
				files.addAll(getResourcAsFiles(child.getAbsoluteFile(),ext));
			}
		}
		return files;
	}
	public static List<File> getResourcAsFiles(String resourceLocation, final String ext) {
		File file=getResourcAsFile(resourceLocation);
		return getResourcAsFiles(file, ext);
	}
	/**
	 * 根据URL获取文件
	 * @param url
	 * @return
	 */
	public static File getResourcAsFile(URL url) {
		String urlStr = url.toString();
		String uriStr = StringUtils.replace(urlStr, " ", "%20");
		URI uri = null;
		try {
			uri = new URI(uriStr);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if (StringUtils.isEqual("file", uri.getScheme())) {
			File file = new File(uri.getSchemeSpecificPart());
			return file;
		} else {
			throw new RuntimeException(" 无法解析文件路径,因为地址不是一个系统文件路径, "
					+ uri.toString());
		}
	}
	
}
