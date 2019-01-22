package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotExistsException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {


        private TrackRepository trackRepository;

        @Autowired
        public TrackServiceImpl(TrackRepository trackRepository) {

            this.trackRepository=trackRepository;
        }
        @Override
        public Track saveTrack(Track track) throws TrackAlreadyExistsException {

            if(trackRepository.existsById(track.getId()))
            {
                throw new TrackAlreadyExistsException("Track already exists");
            }
            Track savedTrack = trackRepository.save(track);
            if (savedTrack == null)
            {
                throw new TrackAlreadyExistsException("Track does not exists");
            }
            return savedTrack;
        }


        @Override
        public List<Track> displayTracks() {

            return trackRepository.findAll();
        }

         @Override
        public Track updateTrack(Track track) {
        Track updatedTrack=trackRepository.save(track);
        return  updatedTrack;
         }

        @Override
        public boolean delTrack(int id) throws TrackNotExistsException {
            boolean status=false;
            if(trackRepository.existsById(id))
            {
                trackRepository.deleteById(id);
                status=true;
                return status;
            }
            else
            {
                throw new TrackNotExistsException("Track does not exists");
            }


    }
}
