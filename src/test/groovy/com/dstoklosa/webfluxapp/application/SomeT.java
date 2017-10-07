package com.dstoklosa.webfluxapp.application;

import com.dstoklosa.webfluxapp.domain.FinancialOfficer;
import com.dstoklosa.webfluxapp.domain.FinancialOfficerRepository;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class SomeT implements FinancialOfficerRepository {

    @Override
    public Mono<FinancialOfficer> save(FinancialOfficer s) {
        return Mono.just(new FinancialOfficer(UUID.randomUUID()));
    }

    @Override
    public <S extends FinancialOfficer> Flux<S> saveAll(Iterable<S> var1) {
        return null;
    }


    public <S extends FinancialOfficer> Flux<S> saveAll(Publisher<S> var1){
        return null;
    }

    @Override
    public Mono<FinancialOfficer> findById(UUID uuid) {
        return null;
    }

    @Override
    public Mono<FinancialOfficer> findById(Publisher<UUID> publisher) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(UUID uuid) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<UUID> publisher) {
        return null;
    }

    @Override
    public Flux<FinancialOfficer> findAll() {
        return null;
    }

    @Override
    public Flux<FinancialOfficer> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public Flux<FinancialOfficer> findAllById(Publisher<UUID> publisher) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(UUID uuid) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<UUID> publisher) {
        return null;
    }

    @Override
    public Mono<Void> delete(FinancialOfficer financialOfficer) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends FinancialOfficer> iterable) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends FinancialOfficer> publisher) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
