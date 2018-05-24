package com.ssg.casino.domain;

import javafx.scene.media.MediaPlayerBuilder;

public class ObjectFather {

    public PlayerBuilder newPlayer() {
        return new PlayerBuilder();
    }
}
