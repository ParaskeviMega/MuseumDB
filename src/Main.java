public class Main {

    public static void main(String[] args) {
        ExhibitDAO object = new ExhibitDAO();
        //id, title, artist, date, culture, description
        Exhibit first = new Exhibit(1, "Panel with San Millán", "Master Engelram",
                1060, "Spanish", "Ivories-Elephant");
        // create museum table into mysql database
        object.createTable();
        object.printAll();
        // add data
        object.insert(first);
        object.printAll();
        Exhibit second = new Exhibit();
        // the id of the exhibit we want to update
        second.setId(1);
        // and the update we want to do
        second.setArtist("Arvind");
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