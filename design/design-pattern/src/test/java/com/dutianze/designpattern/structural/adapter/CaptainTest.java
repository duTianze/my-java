package com.dutianze.designpattern.structural.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * @author dutianze
 * @date 2022/8/11
 */
class CaptainTest {

    private Map<String, Object> beans;

    private static final String FISHING_BEAN = "fisher";

    private static final String ROWING_BEAN = "captain";

    @BeforeEach
    public void setup() {
        beans = new HashMap<>();

        FishingBoatAdapter fishingBoatAdapter = spy(new FishingBoatAdapter());
        beans.put(FISHING_BEAN, fishingBoatAdapter);

        Captain captain = new Captain();
        captain.setRowingBoat((FishingBoatAdapter) beans.get(FISHING_BEAN));
        beans.put(ROWING_BEAN, captain);
    }

    @Test
    void testAdapter() {
        Captain captain = (Captain) beans.get(ROWING_BEAN);

        // when captain moves
        captain.row();

        // the captain internally calls the battleship object to move
        RowingBoat adapter = (RowingBoat) beans.get(FISHING_BEAN);
        verify(adapter).row();
    }

}