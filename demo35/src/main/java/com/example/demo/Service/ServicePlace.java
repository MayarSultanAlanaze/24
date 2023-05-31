package com.example.demo.Service;

import com.example.demo.ApiException.ApiException;
import com.example.demo.Model.Place;
import com.example.demo.Repository.RepositoryPlace;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicePlace {
    private final RepositoryPlace repositoryPlace;
    public List<Place> getPlace() {
        return repositoryPlace.findAll();
    }

    public void addPlace(Place place) {
        repositoryPlace.save(place);
    }

    public Place updateplace(Place place, Integer id) {
       Place place1 = repositoryPlace.getById(id);
        if (place1 == null) {
           place1.setName(place.getName());
           place1.setCity(place.getCity());
           place1.setRole(place.getRole());
        }
        repositoryPlace.save(place1);
        return place1;

    }

    public Place deletePlace(Integer id) {
       Place place = repositoryPlace.getById(id);
        if (place == null) {
            throw new ApiException("MOVIE DELETE");
        }
        repositoryPlace.delete(place);
        return place;
    }

}
