package com.hostfully.demo;

import com.hostfully.demo.api.PropertyService;
import com.hostfully.demo.api.PropertyServiceImpl;
import com.hostfully.demo.repository.BookingRepository;
import com.hostfully.demo.repository.Repository;
import com.hostfully.demo.service.BookingService;
import com.hostfully.demo.service.Service;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(BookingService.class).to(Service.class).in(Singleton.class);
        bind(BookingRepository.class).to(Repository.class).in(Singleton.class);
        bind(PropertyServiceImpl.class).to(PropertyService.class).in(Singleton.class);
    }
}