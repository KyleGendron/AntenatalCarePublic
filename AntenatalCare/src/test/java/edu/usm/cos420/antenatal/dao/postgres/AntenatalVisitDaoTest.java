package edu.usm.cos420.antenatal.dao.postgres;

import edu.usm.cos420.antenatal.dao.concete.PostgresVisitDao;
import edu.usm.cos420.antenatal.daoFactory.Postgres;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.view.VisitForm;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by aaron on 4/16/2016.
 */
public class AntenatalVisitDaoTest {
  private static Postgres db;
  private static PostgresVisitDao dao;
  private static PregnancyVisit record;
  private static ArrayList<String> idList;

  @BeforeClass
  public static void setUp() throws Exception {
    db = new Postgres();
    dao = db.getAntenatalVisitDao();
    Assert.assertNotNull(dao);
    idList = new ArrayList<>();

    VisitForm form = new VisitForm(new FlowLayout());
    record = new PregnancyVisit(form);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    idList.forEach(s -> dao.remove(s));
    System.out.println("Cleaning up leftover IDs");
    db.closeConnection();
  }

  @Test
  public void testAdd() throws Exception {
    String id = UUID.randomUUID().toString();
    record.setId(id);
    int result = dao.add(id, record);
    idList.add(id);

    Assert.assertEquals(true, result > 0);
  }

  @Test
  public void testUpdate() throws Exception {
    String id = UUID.randomUUID().toString();
    record.setId(id);
    dao.add(id, record);
    record.setParity(99);
    record.setEDD(LocalDate.now());
    int updateResult = dao.update(id, record);
    idList.add(id);

    Assert.assertEquals(true, updateResult > 0);
  }

  @Test
  public void testRemove() throws Exception {
    String id = UUID.randomUUID().toString();
    record.setId(id);
    dao.add(id, record);
    int removeResult = dao.remove(id);

    Assert.assertEquals(true, removeResult > 0);
  }

  @Test
  public void testFind() throws Exception {
    String id = UUID.randomUUID().toString();
    record.setId(id);
    dao.add(id, record);
    PregnancyVisit result = dao.find(id);
    idList.add(id);
    Assert.assertNotNull(result);
  }

  @Test
  public void testList() throws Exception {
    Assert.assertNotNull(dao.list());
  }
}
