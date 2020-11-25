package tw.group4._35_.geo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PositionDao implements InterfacePositionDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public PositionDao(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Position> readAllToPt() {

		Session session = sessionFactory.getCurrentSession();
		
		Query<Position> query = session.createQuery("From Position", Position.class);
		List<Position> list = query.list();	

		return list;
	}
	
	@Override
	public List<Position> readNoNullToPt() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Position> query = session.createQuery("From Position where latitude > 0", Position.class);
		List<Position> list = query.list();	

		return list;
	}
	
	@Override
	public List<Activity> selectDistinctToAct() {	 
		Session session = sessionFactory.getCurrentSession();
		
		Query<Object[]> query = session.createQuery("Select id, title, time From Activity");
		List <Object[]> resultList = query.getResultList();
		
		
		List<Activity> list= new ArrayList<Activity>();
		for (Object[] item: resultList) {
			Activity act = new Activity();

			int id = Integer.parseInt((item[0]).toString());
			act.setId(id);
			act.setTitle(String.valueOf(item[1]));
			act.setTime(String.valueOf(item[2]));
			list.add(act);
		}
		
		return list;
	}

}
