public class Main {
    //id, title, artist, date, culture, description
    public static void main(String[] args) {
        ExhibitDAO object = new ExhibitDAO();
        Exhibit first = new Exhibit();
        // create museum table into mysql database
        object.createTable();
        first.setId(1);
        first.setTitle("Panel with San Millán");
        first.setArtist("Master Engelram");
        first.setDate(1060);
        first.setCulture("Spanish");
        first.setDescription("Ivories-Elephant");
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
        // deletie data
        object.delete(1);
        // print data
        object.printAll();
        // delete museum table
        object.dropTable();
    }
}