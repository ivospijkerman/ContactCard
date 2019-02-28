package nl.spijkerman.ivo.contactcard.controller;

import nl.spijkerman.ivo.contactcard.model.Contact;

public interface ContactSource {

    Contact getById(int id);

    Contact[] getAll();
}
