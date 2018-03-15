package com.isenpai.scc;

import com.isenpai.scc.dao.acas.ASRMessage;
import com.isenpai.scc.parsers.ASRKt;
import com.isenpai.scc.parsers.InputDataParser;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		final ASRMessage asr = InputDataParser.parseASR("/Example_ASR.xml");
		ASRKt.print(asr);
	}
}
