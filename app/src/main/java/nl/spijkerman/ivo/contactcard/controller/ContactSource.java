package nl.spijkerman.ivo.contactcard.controller;

import nl.spijkerman.ivo.contactcard.model.Contact;

public interface ContactSource {
    String SOURCE_PREF = "SOURCE_PREF";
    String USE_REPO = "USE_REPO";

    Contact getById(int id);
    Contact[] getAll();
}
