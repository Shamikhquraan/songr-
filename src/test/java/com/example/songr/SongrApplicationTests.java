package com.example.songr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SongrApplicationTests {

	@Test
	void testTitle() {
		Album album1 = new Album("figting", "Shamikh Qu","15", "59:20", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
		String title = album1.getTitle();
		assertEquals("figting", title);
	}
	@Test
	void testArtist() {
		Album album1 = new Album("watforf", "mohammad salah","13", "60:60", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
		String artist = album1.getArtist();
		assertEquals("mohammad salah", artist);
	}
	@Test
	void testNumber() {
		Album album1 = new Album("PSG", "Alter","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
		String count = album1.getSongCount();
		assertEquals("13", count);
	}
	@Test
	void testLength() {
		Album album1 = new Album("Blackbird", "Alter bridge","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
		String count = album1.getLength();
		assertEquals("59:17", count);
	}
	@Test
	void testUrl() {
		Album album1 = new Album("real Madrid", "benzema","13", "59:17", "https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg" );
		String url = album1.getImageUrl();
		assertEquals("https://upload.wikimedia.org/wikipedia/en/1/13/Alterbridge_blackbird.jpg", url);
	}
}