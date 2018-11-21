package nl.spijkerman.ivo.contactcard.controller;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import nl.spijkerman.ivo.contactcard.model.Contact;
import nl.spijkerman.ivo.contactcard.model.Result;

public enum ContactController {
    INSTANCE;

    private Contact[] contacts;

    private class ContactLoader extends AsyncTask<Void, Void, Contact[]> {
        @Deprecated
        private final static String example = "{\"results\":[{\"gender\":\"male\",\"name\":{\"title\":\"mr\",\"first\":\"سپهر\",\"last\":\"سلطانی نژاد\"},\"location\":{\"street\":\"2668 شهید کشواد\",\"city\":\"خمینی\u200Cشهر\",\"state\":\"کرمانشاه\",\"postcode\":22363,\"coordinates\":{\"latitude\":\"28.1515\",\"longitude\":\"-4.3067\"},\"timezone\":{\"offset\":\"+5:30\",\"description\":\"Bombay, Calcutta, Madras, New Delhi\"}},\"email\":\"سپهر.سلطانینژاد@example.com\",\"login\":{\"uuid\":\"75b485d2-63c1-4066-986b-eb3e2bd65c67\",\"username\":\"happypeacock912\",\"password\":\"lady\",\"salt\":\"ymXfazzh\",\"md5\":\"3b06960532148c2256d2a2d726980c05\",\"sha1\":\"8729a2738c6035c70a7599c995d6ad22ccead05f\",\"sha256\":\"02a3d799e524cd18d227922ce4a7d698a6200e4ce18d6f65ab552ecec545aac7\"},\"dob\":{\"date\":\"1983-08-12T03:29:44Z\",\"age\":35},\"registered\":{\"date\":\"2005-12-30T02:49:02Z\",\"age\":12},\"phone\":\"017-83374451\",\"cell\":\"0929-920-2622\",\"id\":{\"name\":\"\",\"value\":null},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/men/90.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/men/90.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/men/90.jpg\"},\"nat\":\"IR\"}],\"info\":{\"seed\":\"8a583f5344f42a12\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}";

        @Override
        protected Contact[] doInBackground(Void... voids) {
            System.out.println("doInBackground");
            try {
                ObjectMapper mapper = new ObjectMapper();
                Result result = mapper.readValue(example, Result.class);
                Contact contact = result.results.get(0);
                System.out.println("Success");
                return new Contact[]{contact};
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Fail");
                return new Contact[0];
            }
        }

//        @Override
//        protected void onPostExecute(Contact[] result) {
//            System.out.println("onPostExecute");
//            contacts = result;
//        }
    }

    ContactController() {
        AsyncTask<Void, Void, Contact[]> loader = new ContactLoader();

        contacts = ((ContactLoader) loader).doInBackground();
    }

    public Contact getById(int id) {
        if (id < 0 || id > contacts.length)
            throw new IllegalArgumentException();
        return contacts[id];
    }

    public Contact[] getAll(int id) {
        return contacts;
    }

}