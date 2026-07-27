package com.snake.Utils;

import java.awt.*;
import java.io.Serializable;

public class FontDefault implements Serializable {

    public Font getDefaultFont(){
        return getDefaultFont(20);
    }

    public Font getDefaultFont(Integer size){
        return new Font("ARIAL", Font.BOLD, size);
    }



}
