package com.dutianze.designpattern.adapter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dutianze
 * @date 2022/8/11
 */
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Captain {

    private RowingBoat rowingBoat;

    void row() {
        rowingBoat.row();
    }

}
