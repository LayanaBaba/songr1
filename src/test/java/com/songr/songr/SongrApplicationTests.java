package com.songr.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

//	@Test
//	void albumTest(){
//		var album= new Album("title1","artist1",2,5,"url1");
//
//		Assertions.assertEquals("title1", album.getTitle());
//		Assertions.assertEquals("artist1", album.getArtist());
//		Assertions.assertEquals(2, album.getSongCount());
//		Assertions.assertEquals(5, album.getLength());
//		Assertions.assertEquals("url1", album.getImageUrl());
//	}

	@Test
	void titleSetTest(){
		var album= new Album();

		album.setTitle("title1");

		Assertions.assertEquals("title1", album.getTitle());

	}

	@Test
	void artistSetTest() {
		var album = new Album();

		album.setArtist("artist");

		Assertions.assertEquals("artist", album.getArtist());
	}
	@Test
	void soundCountSetTest() {
		var album = new Album();

		album.setSongCount(1);

		Assertions.assertEquals(1, album.getSongCount());
	}
	@Test
	void lengthSetTest() {
		var album = new Album();

		album.setLength(5);

		Assertions.assertEquals(5, album.getLength());
	}
	@Test
	void urlSetTest() {
		var album = new Album();

		album.setImageUrl("url");

		Assertions.assertEquals("url", album.getImageUrl());
	}
}
