package com.isenpai.scc.parsers;

import com.isenpai.scc.dao.acas.ARFMessage;
import com.isenpai.scc.dao.acas.ASRMessage;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class InputDataParser
{
	private static DocumentBuilder db = null;

	/**
	 * @return a DocumentBuilder that should be used for parsing XML
	 */
	private static DocumentBuilder getDocumentBuilder() throws ParserConfigurationException
	{
		if(db == null)
		{
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);
			dbf.setIgnoringComments(true);
			dbf.setNamespaceAware(false);

			db = dbf.newDocumentBuilder();
		}

		return db;
	}

	/**
	 * Parses an ASR file
	 * @param resourceName the name of the resource on the classpath
	 */
	public static ASRMessage parseASR(final String resourceName) throws ParserConfigurationException, IOException, SAXException
	{
		Objects.requireNonNull(resourceName);

		try(InputStream in = InputDataParser.class.getResourceAsStream(resourceName))
		{
			return parseASR(in);
		}
	}

	private static ASRMessage parseASR(final InputStream in) throws ParserConfigurationException, IOException, SAXException
	{
		final Document doc = getDocumentBuilder().parse(in);
		return ASRKt.parseASRFile(doc);
	}

	/**
	 * Parses an ARF file
	 * @param resourceName the name of the resource on the classpath
	 */
	public static ARFMessage parseARF(final String resourceName) throws ParserConfigurationException, IOException, SAXException
	{
		Objects.requireNonNull(resourceName);

		try(InputStream in = InputDataParser.class.getResourceAsStream(resourceName))
		{
			return parseARF(in);
		}
	}

	private static ARFMessage parseARF(final InputStream in) throws ParserConfigurationException, IOException, SAXException
	{
		final Document doc = getDocumentBuilder().parse(in);
		return ARFKt.parseARFFile(doc);
	}
}
