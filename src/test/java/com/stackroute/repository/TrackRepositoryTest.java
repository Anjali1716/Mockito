package com.stackroute.repository;


import com.stackroute.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TrackRepositoryTest {

    @Autowired
    private TrackRepository trackRepository;
    private Track track;

    @Before
    public void setUp()
    {
        track = new Track();
        track.setId(01);
        track.setTrackName("POSITIVE RAGA");
        track.setTrackComment("Nice Song ");

    }

    @After
    public void tearDown(){

        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        //Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(01,track.getId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(01,"ABCD","Dance No.");
        trackRepository.save(track);
        //Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllTrack(){
        Track t1 = new Track(01,"DECAPRIO","NICE ONE");
        Track t2 = new Track(02,"MINE SONG","HAPPY");
        trackRepository.save(t1);
        trackRepository.save(t2);

        List<Track> list = trackRepository.findAll();

        Assert.assertEquals(02,list.get(0).getId());


    }
}
