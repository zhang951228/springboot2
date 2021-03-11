package com.erayt.single.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Auther: Z151
 * @Date: 2021/3/11 10:52
 */
@Service
public interface NIOService {

	StringBuilder readFile() throws IOException;
}
