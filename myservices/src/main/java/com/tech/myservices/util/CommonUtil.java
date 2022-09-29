package com.tech.myservices.util;

import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtil {
	
	public static StopWatch stopWatch=new StopWatch();

	public static  void startTimer()
	{
		stopWatch.start();
	}
	
	public static void timeTaken()
	{
		stopWatch.stop();
		log.info(" Time taken to execute :"+stopWatch.getTotalTimeMillis());
		log.info(" task summary: "+stopWatch.shortSummary());
		
	}
}
