package com.tianqiauto.quartz.jobs.socket.dao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tianqiauto.base.dao.BaseService;
import com.tianqiauto.base.model.ProcedureContext;
import com.tianqiauto.base.model.ProcedureParam;
import com.tianqiauto.quartz.jobs.socket.client.TcpClient;
import com.tianqiauto.quartz.jobs.socket.utils.CRCUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * soucket发送数据
 * @author白炯威
 */
@Repository
public class SendDataDao {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	
	@Value("${client.tcp.port}")
	private int port;
	
	@Value("${client.tcp.ip}")
	private String ip;
	
	@Autowired
	private BaseService baseService;
	
	/**
	 * 存储过程名
	 */
	private static final String PRO_NAME = "JOB_SS_DNSJCS";
	
	public void sendData() throws Exception {
		//机台电能数据
		String axdl="A相电流";  //包含配电房A相电流
		String bxdl="B相电流";  //包含配电房B相电流
		String cxdl="C相电流";  //包含配电房C相电流
		String zygdn="总有功电能";
		//配电房数据
		String dl = "电流";
		String ygzdn = "有功总电能";
		//这部分数据为配电总表数据和东17,西13号总有功电能
		String pdzb = "配电总表";

		TcpClient tc = new TcpClient(ip, port);
		List<String> sendData1 = this.getData(baseService,PRO_NAME,axdl);
		for(String sendData:sendData1){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData2 = this.getData(baseService,PRO_NAME,bxdl);
		for(String sendData:sendData2){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData3 = this.getData(baseService,PRO_NAME,cxdl);
		for(String sendData:sendData3){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData4 = this.getData(baseService,PRO_NAME,zygdn);
		for(String sendData:sendData4){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData5 = this.getData(baseService,PRO_NAME,dl);
		for(String sendData:sendData5){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData6 = this.getData(baseService,PRO_NAME,ygzdn);
		for(String sendData:sendData6){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

		List<String> sendData7 = this.getData(baseService,PRO_NAME,pdzb);
		for(String sendData:sendData7){
			tc.invokeFront(sendData);
			log.info(sendData);
		}

	}

	/**
	 * 通过数据库获取数据
	 * @param proName 过程名称
	 * @param csmc 参数名称['A相电流','总有功电能']
	 * @throws UnsupportedEncodingException
	 */
	public List<String> getData(BaseService baseService, String proName, String csmc) throws UnsupportedEncodingException{
		List<ProcedureParam> paramList = new ArrayList<ProcedureParam>();
		ProcedureParam pp = new ProcedureParam(1, csmc, Types.VARCHAR, "IN");
		paramList.add(pp);
		ProcedureContext context = baseService.callProcedure(proName, paramList);
		JSONArray jsonArray = context.getDatas();
		int pageSize = 99;
		List<String> list = new ArrayList<String>();
		int dataSize = jsonArray.size();

		int pageHJ = (int)Math.ceil((double)dataSize/pageSize); 
		for(int t=0;t<pageHJ;t++){
			StringBuilder sb = new StringBuilder();
			int temp = t+1==pageHJ?dataSize:(t+1)*99;
			for (int i = t*pageSize; i < temp; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				sb.append(jsonObject.get("DATASTR"));
				sb.append(";");
			}
			String dataStr = sb.toString();
			dataStr = dataStr.substring(0,dataStr.length()-1);
			list.add(this.splitJointStr(dataStr));
		}
		return list;
	}
	
	/**
	 * 拼接要发送的数据
	 * 
	 * 	1．##：起始符
	 *	2．0460：数据长度（5个字节，从QN开始的下划线部分，不包括CRC较验1DC0）。
	 *	3．QN=20100709100520000;：其中QN为产生该数据包的当前时间标识，格式为yyyyMMddHHmmssttt，其中ttt为毫秒数。
	 *	4.CSMC=L1相电流; DW=A；CP=&&：此部分不要变。
	 *	5.并条101=20180306094058|1.17...:数据部分   机台号 = 创建时间（格式为yyyyMMddHHmmss） | 参数值
	 *	6．&&：数据部分的结束符。
	 *	7．1DC0：CRC校验码（4个字节，下划线部分即QN开始至&&结束的CRC，算法附后）
	 *	8．终止符：回车换行符
	 *	9．其他说明：各分隔符分号(;)为英文字符。
	 * 
	 */
	private String splitJointStr(String dataStr) throws UnsupportedEncodingException{
		//起始符
		String qsf = "##";	
		//数据长度（5个字节，从QN开始的下划线部分，不包括CRC较验1DC0）。
		String sjcd;	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//产生该数据包的当前时间标识，格式为yyyyMMddHHmmssttt，其中ttt为毫秒数。
		String qn = sdf.format(new Date());	
		//数据开始符号
		String sjbfksf="CP=&&";
		//数据部分的结束符。
		String sjbfjsf="&&";
		//CRC校验码（4个字节，下划线部分即QN开始至&&结束的CRC，算法附后）
		String crc;			
		StringBuilder sb = new StringBuilder();
		sb.append(qsf);
		//校验部分数据
		StringBuilder jybf = new StringBuilder();
		jybf.append("QN=");
		jybf.append(qn+";");
		jybf.append("ST=64;CN=2051;PW=999999;MN=98820180830002;Flag=1;");
		jybf.append(sjbfksf);
		SimpleDateFormat dataTimeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dataTime = dataTimeFormat.format(new Date());	
		jybf.append("DataTime="+dataTime+";");
		jybf.append(dataStr);
		jybf.append(sjbfjsf);
		String jybfStr = jybf.toString();
		//获取数据长度
		sjcd = String.format("%4s", jybfStr.length()).replaceAll(" ", "0");
		sb.append(sjcd);
		sb.append(jybfStr);
		//crc校验码
		crc = CRCUtil.getCrcHexString(jybfStr.getBytes());
		sb.append(crc);	
		return sb.toString();
	}
	
}
