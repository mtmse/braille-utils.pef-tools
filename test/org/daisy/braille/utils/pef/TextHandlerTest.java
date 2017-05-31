package org.daisy.braille.utils.pef;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.daisy.braille.utils.api.table.TableCatalog;
import org.junit.Test;

public class TextHandlerTest {
	private static final String DEFAULT_TABLE_ID = "org.daisy.braille.impl.table.DefaultTableProvider.TableType.EN_US";

	@Test (expected=RuntimeException.class)
	public void testTooManyRows() throws URISyntaxException, IOException {
		File output = File.createTempFile(this.getClass().getCanonicalName(), ".tmp");
		output.deleteOnExit();
		TableCatalog tc = TableCatalog.newInstance();
		TextHandler th = 
				new TextHandler.Builder(new File(this.getClass().getResource("resource-files/width-height-test.txt").toURI()), output, tc)
				.converterId(DEFAULT_TABLE_ID)
				.rowsLimit(10)
				.build();
		th.parse();
	}

	@Test (expected=RuntimeException.class)
	public void testTooManyCols() throws URISyntaxException, IOException {
		File output = File.createTempFile(this.getClass().getCanonicalName(), ".tmp");
		output.deleteOnExit();
		TableCatalog tc = TableCatalog.newInstance();
		TextHandler th = 
				new TextHandler.Builder(new File(this.getClass().getResource("resource-files/width-height-test.txt").toURI()), output, tc)
				.converterId(DEFAULT_TABLE_ID)
				.colsLimit(10)
				.build();
		th.parse();
	}


	@Test
	public void testRowsFitWithLimit() throws URISyntaxException, IOException {
		File output = File.createTempFile(this.getClass().getCanonicalName(), ".tmp");
		output.deleteOnExit();
		TableCatalog tc = TableCatalog.newInstance();
		TextHandler th = 
				new TextHandler.Builder(new File(this.getClass().getResource("resource-files/width-height-test.txt").toURI()), output, tc)
				.converterId(DEFAULT_TABLE_ID)
				.rowsLimit(11)
				.build();
		th.parse();
	}

	@Test
	public void testColsFitWithLimit() throws URISyntaxException, IOException {
		File output = File.createTempFile(this.getClass().getCanonicalName(), ".tmp");
		output.deleteOnExit();
		TableCatalog tc = TableCatalog.newInstance();
		TextHandler th = 
				new TextHandler.Builder(new File(this.getClass().getResource("resource-files/width-height-test.txt").toURI()), output, tc)
				.converterId(DEFAULT_TABLE_ID)
				.colsLimit(11)
				.build();
		th.parse();
	}

	@Test
	public void testRowsColsFitNoLimit() throws URISyntaxException, IOException {
		File output = File.createTempFile(this.getClass().getCanonicalName(), ".tmp");
		output.deleteOnExit();
		TableCatalog tc = TableCatalog.newInstance();
		TextHandler th = 
				new TextHandler.Builder(new File(this.getClass().getResource("resource-files/width-height-test.txt").toURI()), output, tc)
				.converterId(DEFAULT_TABLE_ID)
				.build();
		th.parse();
	}

}
