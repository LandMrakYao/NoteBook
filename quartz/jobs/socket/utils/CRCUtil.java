package com.tianqiauto.quartz.jobs.socket.utils;

/**
 * CRC加密算法
 * ① 装一个 16 位寄存器，所有数位均为1。
 * ② 取被校验串的一个字节与16 位寄存器的高位字节进行“异或”运算。运算结果放入这个16 位寄存器。
 * ③ 把这个 16 寄存器向右移一位。
 * ④ 若向右（标记位）移出的数位是1，则生成多项式1010 0000 0000 0001 和这个寄存器进行“异或”运算；若向右移出的数位是0，则返回③。
 * ⑤ 重复③和④，直至移出 8 位。
 * ⑥ 取被校验串的下一个字节
 * ⑦ 重复③~⑥，直至被校验串的所有字节均与16 位寄存器进行“异或”运算，并移位8 次。
 * ⑧ 这个 16 位寄存器的内容即2 字节CRC 错误校验码。
 * 校验码按照先高字节后低字节的顺序存放。
 * 
 * @author 白炯威
 * @version 1.0
 *
 */
public class CRCUtil {

	/**
	 * 获取CRC16进制密文
	 * @param data 需要加密的数据，数据类型BYTE
	 * @return 数据CRC加密后生成的16进制密文
	 */
    public static String getCrcHexString(byte[] data) {  
        int high;  
        int flag;  
        int wcrc = 0xffff;  
        for (int i = 0; i < data.length; i++) {  
            high = wcrc >> 8;  
            wcrc = high ^ data[i];  
            for (int j = 0; j < 8; j++) {  
                flag = wcrc & 0x0001;  
                wcrc = wcrc >> 1;  
                if (flag == 1)  
                    wcrc ^= 0xa001;  
            }  
        }  
        return Integer.toHexString(wcrc).toUpperCase();  
    }  
    
    /**
	 * 获取CRC16进制密文
	 * @param str 需要加密的数据，数据类型String
	 * @return 数据CRC加密后生成的16进制密文
	 */
    public static String getCrcHexString(String str) {
    	return getCrcHexString(str.getBytes());
    }
    
}
