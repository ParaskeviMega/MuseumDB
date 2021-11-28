public class Main {

    public static void main(String[] args) {
        ExhibitDAO object = new ExhibitDAO();
        //id, title, artist, date, culture, description
        Exhibit first = new Exhibit(1, "Panel with San Millán", "Master Engelram",
                1060, "Spanish", "Ivories-Elephant");
        // create museum table into mysql database
        object.createTable();
        Exhibit second = new Exhibit();
        // id -> the row we want to update
        second.setId(1);
        second.setArtist("Arvind");
        // add data
        object.insert(first);
        object.printAll();
        // update data
        object.update(second);
        object.printAll();
        // delete data
        object.delete(1);
        // print data
        object.printAll();
        // delete museum table
        object.dropTable();
    }
}