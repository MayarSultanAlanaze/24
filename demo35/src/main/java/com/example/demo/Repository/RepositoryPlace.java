package com.example.demo.Repository;

import com.example.demo.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPlace extends JpaRepository<Place,Integer> {
     Place findAllById(Integer id);
     Place getPlaceByName(String name);
     Place getPlaceByCity(String name);
     Place getPlaceByRole(String role);
}
