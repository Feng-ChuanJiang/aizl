package org.lemonPig.os.assist.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.lemonPig.os.common.StringUtils;

public class SaltHashHelper {
	//hash算法名字
	private String hashAlgorithmName;
	private Integer hashIterations;
	DefaultHashService hashService=null; // 默认算法SHA-512
	public SaltHashHelper(String hashAlgorithmName, String privateSalt, Integer hashIterations) {
		this.hashAlgorithmName = hashAlgorithmName;
		this.hashIterations = hashIterations;
		if (StringUtils.isBlank(privateSalt)) {
			privateSalt="lemonPig";
		}
		//设置默认值
		hashService= new DefaultHashService();
		hashService.setHashAlgorithmName("MD5");
		hashService.setPrivateSalt(new SimpleByteSource(privateSalt)); // 私盐，默认无
		hashService.setGeneratePublicSalt(true);// 是否生成公盐，默认false
		hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());// 用于生成公盐。默认就这个
		hashService.setHashIterations(2); // 生成Hash值的迭代次数
	}

	/**
	 * hash对比
	 * @param token 未加密验证参数
	 * @param info 已加密验证参数
	 * @return
	 */
	public boolean hashMache(AuthenticationToken token,
			AuthenticationInfo info) {
		SimpleAuthenticationInfo sainfo=(SimpleAuthenticationInfo) info;
		String hex=getHash(token.getCredentials(), sainfo.getCredentialsSalt());
		if (hex.equals(info.getCredentials())) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 获取字符串hash值
	 * @param s 待处理字符串
	 * @return hash计算后的字符串
	 */
	public String getHash(Object object,Object publicSalt) {
		HashRequest request = new HashRequest.Builder().setAlgorithmName(hashAlgorithmName)
				.setSource(ByteSource.Util.bytes(object))
				.setSalt(ByteSource.Util.bytes(publicSalt)).setIterations(hashIterations).build();
		String hex = hashService.computeHash(request).toHex();
		return hex;
	}
}
