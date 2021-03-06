package org.anveshgadde.sql;


import java.util.Properties;

import dnl.utils.text.table.TextTable;

public class ClipBoardMain {

	final Properties properties = new Properties();

	public static void main(String[] args) throws Exception {

		String propFilePath;

		if (args.length < 2) {
			propFilePath = "C:\\Users\\anveshg\\Desktop\\RptOpt\\Attachments\\src\\main\\java\\resources\\database.properties";
		} else {
			propFilePath = args[1];
		}

		ClipboardTextTransfer clip = new ClipboardTextTransfer();

		String querySQL = clip.getClipboardContents();

		@SuppressWarnings("unused")
		DBConnection db = new DBConnection(propFilePath);

		Query query = new Query(DBConnection.getProdRPTOracle(), querySQL);

		TextTable tt = new TextTable((String[]) query.getHeaders(), query.getData());

		tt.setAddRowNumbering(true);

		tt.setSort(0);
		tt.printTable();

	}

}
