package com.stackroute.controller;

import com.stackroute.domain.Track;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class TrackController {

    TrackService trackService;
    ResponseEntity responseEntity;

    @Autowired
    public TrackController(TrackService trackService) {

        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {

        try {
            trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }


    @GetMapping("track")
    public ResponseEntity<?> displayTracks() {
        return new ResponseEntity<List<Track>>(trackService.displayTracks(), HttpStatus.OK);
    }

    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){

        try {
            trackService.updateTrack(track);
            responseEntity = new ResponseEntity<String>("Updated", HttpStatus.CREATED);
        } catch (Exception exception) {

            responseEntity = new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> delTrack(@PathVariable("id") int id) {

        try {
            trackService.delTrack(id);
            responseEntity = new ResponseEntity<String>("deleted successfully", HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;
    }

}

