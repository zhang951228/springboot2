package com.erayt.single.service.impl;

import com.erayt.single.service.NIOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 10:53
 */
@Service
@Slf4j
public class NIOServiceImpl  implements NIOService {

	public StringBuilder readFile() throws IOException {

		Path path = Paths.get("C:\\Users\\admin\\Desktop\\xre\\xreport.ap02.log.2021-03-08");
		AsynchronousFileChannel fileChannel =
		AsynchronousFileChannel.open(path, StandardOpenOption.READ);
		ByteBuffer buffer = ByteBuffer.allocate(10240);
		long position = 0;
		Future<Integer> operation = fileChannel.read(buffer, position);
		while(!operation.isDone());
		buffer.flip();
		StringBuilder stringBuilder = new StringBuilder(buffer.limit());
		byte[] data = new byte[buffer.limit()];
		buffer.get(data);
		stringBuilder.append(buffer);
		log.info(new String(data));
		buffer.clear();

		position = 1024;
		operation = fileChannel.read(buffer, position);
		while(!operation.isDone());
		buffer.flip();
		stringBuilder = new StringBuilder(buffer.limit());
		data = new byte[buffer.limit()];
		buffer.get(data);
		stringBuilder.append(buffer);
		log.info(new String(data));
		buffer.clear();

		position = 1024 *2;
		operation = fileChannel.read(buffer, position);
		while(!operation.isDone());
		buffer.flip();
		stringBuilder = new StringBuilder(buffer.limit());
		data = new byte[buffer.limit()];
		buffer.get(data);
		stringBuilder.append(buffer);
		log.info(new String(data));
		buffer.clear();

		position = 1024 *3;
		operation = fileChannel.read(buffer, position);
		while(!operation.isDone());
		buffer.flip();
		stringBuilder = new StringBuilder(buffer.limit());
		data = new byte[buffer.limit()];
		buffer.get(data);
		stringBuilder.append(buffer);
		log.info(new String(data));
		buffer.clear();
		position = 1024 * 4;
		operation = fileChannel.read(buffer, position);
		while(!operation.isDone());
		buffer.flip();
		stringBuilder = new StringBuilder(buffer.limit());
		data = new byte[buffer.limit()];
		buffer.get(data);
		stringBuilder.append(buffer);
		log.info(new String(data));
		buffer.clear();
		return stringBuilder;
	}

	/**
	 * 测试写文件，将文件写入到桌面。
	 * @return
	 * @throws IOException
	 */
	public boolean writeFile() throws IOException {

		Path path = Paths.get("C:\\Users\\admin\\Desktop\\xre\\测试些文件.txt");
		AsynchronousFileChannel fileChannel =
		AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		long position = 1024 * 0;
		buffer.put(generateByte((byte) 'A'));
		buffer.flip();
		Future<Integer> operation = fileChannel.write(buffer, position);
		while(!operation.isDone());
		log.info("Write done A");

		buffer.clear();
		position = 1024 * 1;
		buffer.put(generateByte((byte) 'B'));
		buffer.flip();
		operation = fileChannel.write(buffer, position);
		while(!operation.isDone());
		log.info("Write done B");

		buffer.clear();
		position = 1024 * 2;
		buffer.put(generateByte((byte) 'C'));
		buffer.flip();
		operation = fileChannel.write(buffer, position);
		while(!operation.isDone());
		log.info("Write done C");

		buffer.clear();
		position = 1024 * 3;
		buffer.put(generateByte((byte) 'D'));
		buffer.flip();
		operation = fileChannel.write(buffer, position);
		while(!operation.isDone());
		log.info("Write done D");
		return true;
	}

	/**
	 * 生成数字字符串
	 * @param prefix
	 * @return
	 */
	@Deprecated
	private String generateNumStr(String  prefix){
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<1;i++){
			stringBuilder.append(prefix);
		}
		return stringBuilder.toString();
	}

	/**
	 * 生成指定长度string字符串。
	 * @param prefix
	 * @return
	 */
	private String generateStr(String  prefix){
		StringBuilder stringBuilder = new StringBuilder();
		for (int i =0; i<1024;i++){
			stringBuilder.append(prefix);
		}
		return stringBuilder.toString();
	}

	/**
	 * 生成byte数组
	 * @param aByte
	 * @return
	 */
	private byte[] generateByte(Byte  aByte){
		byte[] bytes = new byte[1024];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = aByte;
		}
		return bytes;
	}
}
