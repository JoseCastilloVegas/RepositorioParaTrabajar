package com.example.Prueba_Test.Repository;

import com.example.Prueba_Test.domain.Animales;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Espia implements AnimalRepository {

    @Override
    public Optional<Animales> findByNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Animales> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Animales> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Animales> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Animales getOne(Long aLong) {
        return null;
    }

    @Override
    public Animales getById(Long aLong) {
        return null;
    }

    @Override
    public Animales getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Animales> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Animales> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Animales> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Animales> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Animales> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Animales> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Animales, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Animales> S save(S entity) {
        return entity;
    }

    @Override
    public <S extends Animales> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Animales> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Animales> findAll() {
        return List.of();
    }

    @Override
    public List<Animales> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Animales entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Animales> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Animales> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Animales> findAll(Pageable pageable) {
        return null;
    }

    public String damePablito(){
        return "Pablito";
    }
}
