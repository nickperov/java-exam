package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamAbstractClass {

}


abstract class Player {
	abstract void play();
	abstract void stop();
}

abstract class MusicPlayer extends Player {
	abstract String getSongTitile();
}

class MP3Player extends MusicPlayer {

	@Override
	String getSongTitile() {
		return null;
	}

	@Override
	void play() {
	}

	@Override
	void stop() {	
	}
}