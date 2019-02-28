package nl.spijkerman.ivo.contactcard.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import nl.spijkerman.ivo.contactcard.model.Contact;
import nl.spijkerman.ivo.contactcard.model.Result;

public enum ContactController implements ContactSource {
    INSTANCE;

    private List<Contact> contacts;

    ContactController() {
        String[] examples = {
                "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"miss\",\"first\":\"sara\",\"last\":\"aarhus\"},\"location\":{\"street\":\"langs linjen 7427\",\"city\":\"follafoss\",\"state\":\"sogn og fjordane\",\"postcode\":\"0693\",\"coordinates\":{\"latitude\":\"51.3588\",\"longitude\":\"157.8727\"},\"timezone\":{\"offset\":\"-7:00\",\"description\":\"Mountain Time (US & Canada)\"}},\"email\":\"sara.aarhus@example.com\",\"login\":{\"uuid\":\"df53d72a-036b-47c0-b739-8435937aa535\",\"username\":\"organicleopard365\",\"password\":\"chichi\",\"salt\":\"oyUDWdoB\",\"md5\":\"b814fc0c493491219800d0b53dcdbc00\",\"sha1\":\"3dfd6dc4ded08430478718237c66dc7988f1837b\",\"sha256\":\"1fb83d0dab3f540fb2e9551e8579e97e1d86746b1efb2cf486d32c8d1170d55c\"},\"dob\":{\"date\":\"1954-12-29T15:38:54Z\",\"age\":63},\"registered\":{\"date\":\"2007-11-19T01:46:25Z\",\"age\":11},\"phone\":\"34663136\",\"cell\":\"93442945\",\"id\":{\"name\":\"FN\",\"value\":\"29125439932\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/54.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/54.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/54.jpg\"},\"nat\":\"NO\"}],\"info\":{\"seed\":\"a21ce0401265e974\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"ms\",\"first\":\"viivi\",\"last\":\"koskela\"},\"location\":{\"street\":\"5569 suvantokatu\",\"city\":\"kauhajoki\",\"state\":\"finland proper\",\"postcode\":50471,\"coordinates\":{\"latitude\":\"-14.0821\",\"longitude\":\"154.4999\"},\"timezone\":{\"offset\":\"+1:00\",\"description\":\"Brussels, Copenhagen, Madrid, Paris\"}},\"email\":\"viivi.koskela@example.com\",\"login\":{\"uuid\":\"f5b78d42-7ae4-4eaf-872d-af3916afeb51\",\"username\":\"ticklishostrich966\",\"password\":\"boricua\",\"salt\":\"N4p6M0GD\",\"md5\":\"97b11deab33aa81d4a1593d3c118d1a7\",\"sha1\":\"266f6b988a70039def85cb681155c5caa1323977\",\"sha256\":\"1172424f6f17a01db642a601c2c9cc84a797b9ceac5803c8abeeeeb3077037fc\"},\"dob\":{\"date\":\"1956-06-30T20:09:56Z\",\"age\":62},\"registered\":{\"date\":\"2011-08-14T05:34:17Z\",\"age\":7},\"phone\":\"05-699-730\",\"cell\":\"048-911-67-75\",\"id\":{\"name\":\"HETU\",\"value\":\"NaNNA560undefined\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/8.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/8.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/8.jpg\"},\"nat\":\"FI\"}],\"info\":{\"seed\":\"de501f62700ebb50\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"miss\",\"first\":\"felicia\",\"last\":\"stockmann\"},\"location\":{\"street\":\"rosenstraße 109\",\"city\":\"kirchhain\",\"state\":\"sachsen-anhalt\",\"postcode\":61063,\"coordinates\":{\"latitude\":\"-45.3110\",\"longitude\":\"161.9162\"},\"timezone\":{\"offset\":\"+2:00\",\"description\":\"Kaliningrad, South Africa\"}},\"email\":\"felicia.stockmann@example.com\",\"login\":{\"uuid\":\"4d18fc7d-9248-41d6-9c70-482ab0534e1f\",\"username\":\"angryfish583\",\"password\":\"hudson\",\"salt\":\"irIhZBJX\",\"md5\":\"d989933807afb0627e37c6157b971c20\",\"sha1\":\"65cb081e3564cdd29800b671c4060a06fd779cd6\",\"sha256\":\"a2d68c3bf94bc41a63f861f578b9da714bbafccf698fff5a3c686aa2cad3ccac\"},\"dob\":{\"date\":\"1954-02-02T15:37:04Z\",\"age\":64},\"registered\":{\"date\":\"2012-10-27T16:11:03Z\",\"age\":6},\"phone\":\"0032-3809815\",\"cell\":\"0176-9132803\",\"id\":{\"name\":\"\",\"value\":null},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/70.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/70.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/70.jpg\"},\"nat\":\"DE\"}],\"info\":{\"seed\":\"9b7f4188b253b66c\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"male\",\"name\":{\"title\":\"mr\",\"first\":\"alexander\",\"last\":\"lee\"},\"location\":{\"street\":\"1264 pt chevalier road\",\"city\":\"napier\",\"state\":\"bay of plenty\",\"postcode\":41619,\"coordinates\":{\"latitude\":\"58.4181\",\"longitude\":\"-128.7687\"},\"timezone\":{\"offset\":\"+4:00\",\"description\":\"Abu Dhabi, Muscat, Baku, Tbilisi\"}},\"email\":\"alexander.lee@example.com\",\"login\":{\"uuid\":\"0692b715-296e-4121-bdf1-369a1698aefa\",\"username\":\"yellowcat272\",\"password\":\"stars\",\"salt\":\"kMA5fjhE\",\"md5\":\"13d89ae389cf9e62af2433d137587db2\",\"sha1\":\"b619e805d50fb980fc35dbba145c8ece864c0342\",\"sha256\":\"21dcf1d8d3b4cc5bc2935cf8b1020ccf2535685c753d10325f6c9cdb3c9c75fd\"},\"dob\":{\"date\":\"1965-04-05T09:25:18Z\",\"age\":53},\"registered\":{\"date\":\"2011-07-15T04:07:25Z\",\"age\":7},\"phone\":\"(145)-569-9655\",\"cell\":\"(819)-595-7797\",\"id\":{\"name\":\"\",\"value\":null},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/men/64.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/men/64.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/men/64.jpg\"},\"nat\":\"NZ\"}],\"info\":{\"seed\":\"9e266f7e6bd33b4b\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"miss\",\"first\":\"deniz\",\"last\":\"koçoğlu\"},\"location\":{\"street\":\"8962 tunalı hilmi cd\",\"city\":\"bursa\",\"state\":\"kayseri\",\"postcode\":75958,\"coordinates\":{\"latitude\":\"75.9994\",\"longitude\":\"137.3930\"},\"timezone\":{\"offset\":\"-8:00\",\"description\":\"Pacific Time (US & Canada)\"}},\"email\":\"deniz.koçoğlu@example.com\",\"login\":{\"uuid\":\"4802ea37-be64-407a-92f4-c763d637be3f\",\"username\":\"crazyrabbit520\",\"password\":\"wheels\",\"salt\":\"3yqcDOLj\",\"md5\":\"b3a0f2b269271200162bacbddeff6469\",\"sha1\":\"cfc791db46b24a81a749fcc4f1dee2f6953ce8e7\",\"sha256\":\"2c3f8943f33dc9328f9c3fc500d90b9ba588b5fbf641cfe20d335673c0f77a34\"},\"dob\":{\"date\":\"1966-02-18T08:55:56Z\",\"age\":52},\"registered\":{\"date\":\"2006-01-07T21:01:57Z\",\"age\":12},\"phone\":\"(424)-792-9238\",\"cell\":\"(602)-511-8377\",\"id\":{\"name\":\"\",\"value\":null},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/81.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/81.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/81.jpg\"},\"nat\":\"TR\"}],\"info\":{\"seed\":\"519f2942efd3e625\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"female\",\"name\":{\"title\":\"miss\",\"first\":\"elly\",\"last\":\"seierstad\"},\"location\":{\"street\":\"åsensvingen 2077\",\"city\":\"løkken\",\"state\":\"akershus\",\"postcode\":\"5398\",\"coordinates\":{\"latitude\":\"49.2890\",\"longitude\":\"84.3690\"},\"timezone\":{\"offset\":\"-6:00\",\"description\":\"Central Time (US & Canada), Mexico City\"}},\"email\":\"elly.seierstad@example.com\",\"login\":{\"uuid\":\"4b332f70-6c05-4462-951d-0875acf4ebef\",\"username\":\"ticklishbear577\",\"password\":\"andreas\",\"salt\":\"Vbtqxj2w\",\"md5\":\"7146a497ac438dcaf4646d5c7f911afe\",\"sha1\":\"a35472677b6dec94d5e646694867abf0745d8dc5\",\"sha256\":\"0e90a59c25f0320d930b013c95c4f172fd78bf10f0ed6e866163bcfcf43052c5\"},\"dob\":{\"date\":\"1969-04-10T11:11:24Z\",\"age\":49},\"registered\":{\"date\":\"2007-11-14T04:33:37Z\",\"age\":11},\"phone\":\"79287894\",\"cell\":\"44728802\",\"id\":{\"name\":\"FN\",\"value\":\"10046919535\"},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/women/63.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/women/63.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/women/63.jpg\"},\"nat\":\"NO\"}],\"info\":{\"seed\":\"cf35013cbbaf459f\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}",
                "{\"results\":[{\"gender\":\"male\",\"name\":{\"title\":\"mr\",\"first\":\"hans-theo\",\"last\":\"weinberger\"},\"location\":{\"street\":\"lindenstraße 29\",\"city\":\"thale\",\"state\":\"sachsen-anhalt\",\"postcode\":27380,\"coordinates\":{\"latitude\":\"-42.2836\",\"longitude\":\"-4.9884\"},\"timezone\":{\"offset\":\"-9:00\",\"description\":\"Alaska\"}},\"email\":\"hans-theo.weinberger@example.com\",\"login\":{\"uuid\":\"6f119dd3-a727-41bd-b78d-4a55dc9068ec\",\"username\":\"lazyswan328\",\"password\":\"jeter2\",\"salt\":\"MCkEeTZU\",\"md5\":\"9630dbb629319e42b469aa5ef07bb66d\",\"sha1\":\"b6af1652a58171fd2e7dbe5a253912d4fa1639c2\",\"sha256\":\"d260b352a35403bf8f30132fe147d8e74c03e4b112d8aa24529752f83f115b99\"},\"dob\":{\"date\":\"1980-10-21T15:48:16Z\",\"age\":38},\"registered\":{\"date\":\"2008-04-12T05:25:08Z\",\"age\":10},\"phone\":\"0875-0459740\",\"cell\":\"0177-9220066\",\"id\":{\"name\":\"\",\"value\":null},\"picture\":{\"large\":\"https://randomuser.me/api/portraits/men/33.jpg\",\"medium\":\"https://randomuser.me/api/portraits/med/men/33.jpg\",\"thumbnail\":\"https://randomuser.me/api/portraits/thumb/men/33.jpg\"},\"nat\":\"DE\"}],\"info\":{\"seed\":\"d6559b00582394f0\",\"results\":1,\"page\":1,\"version\":\"1.2\"}}"
        };

        final int count = examples.length;
        contacts = new ArrayList<>(count);

        ObjectMapper mapper = new ObjectMapper();

        for (int i = 0; i < count; ++i) {
            Result result = null;
            try {
                result = mapper.readValue(examples[i], Result.class);
                contacts.add(result.results.get(0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Contact getById(int id) {
        if (id < 0 || id > contacts.size())
            throw new IllegalArgumentException();
        return contacts.get(id);
    }

    @Override
    public Contact[] getAll() {
        // TODO change saving implementation
        return contacts.toArray(new Contact[0]);
    }

}