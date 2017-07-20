import org.junit.*;
import org.sql2o.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      String deleteStylistsQuery = "DELETE FROM stylists *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      con.createQuery(deleteStylistsQuery).executeUpdate();
    }
  }

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_Stylist1() {
    Stylist testStylist = new Stylist("Stylist1");
    assertEquals("Stylist1", testStylist.getName());
  }

 @Test
 public void all_returnsAllInstancesOfStylist_true() {
   Stylist firstStylist = new Stylist("Stylist1");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Stylist2");
   secondStylist.save();
   assertEquals(true, Stylist.all().get(0).equals(firstStylist));
   assertEquals(true, Stylist.all().get(1).equals(secondStylist));
 }

 @Test
 public void getId_stylistsInstantiateWithAnId_1() {
   Stylist testStylist = new Stylist("Stylist1");
   testStylist.save();
   assertTrue(testStylist.getId() > 0);
 }

 @Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist firstStylist = new Stylist("Stylist1");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Stylist2");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Stylist1");
    Stylist secondStylist = new Stylist("Stylist1");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    Client firstClient = new Client("Client1", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Client2", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Stylist1");
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
  }
}
